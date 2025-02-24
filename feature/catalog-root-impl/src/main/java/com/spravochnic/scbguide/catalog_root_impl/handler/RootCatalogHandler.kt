package com.spravochnic.scbguide.catalog_root_impl.handler

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalog_root_api.mapper.RootCatalogStateMapper
import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel
import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogModel
import com.spravochnic.scbguide.catalog_root_api.repository.RootCatalogRepository
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.status_api.repository.StatusRepository
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootCatalogHandler(
    private val scope: CoroutineScope,
    initialState: RootCatalogComponent.State,
) : InstanceKeeper.Instance, KoinComponent {

    private val rootCatalogRepository by inject<RootCatalogRepository>()
    private val rootCatalogStateMapper by inject<RootCatalogStateMapper>()
    private val statusRepository by inject<StatusRepository>()
    private val rootRouter by inject<RootRouter>()

    val stateValue: MutableValue<RootCatalogComponent.State> = MutableValue(initialState)

    init {
        reload()
    }

    private fun updateLoading() {
        stateValue.value = RootCatalogComponent.State.Request(RequestComponent.State.Loading())
    }

    private fun updateSuccess(rootCatalogListModel: RootCatalogListModel) {
        val items = rootCatalogStateMapper.map(
            model = rootCatalogListModel,
            onClick = ::onClick
        )
        stateValue.value = RootCatalogComponent.State.Success(items)
    }

    private fun updateError(throwable: Throwable) {
        stateValue.value = RootCatalogComponent.State.Request(
            RequestComponent.State.Error(
                message = "Произошла ошибка загрузки",
                buttonReloadMessage = "Обновить?",
                onReloadClick = ::loadData
            )
        )
    }

    private fun loadData() {
        scope.launch {
            updateLoading()
            runCatching {
                withContext(Dispatchers.IO) {
                    delay(1000)

                    async { statusRepository.validateStatus() }.await()

                    rootCatalogRepository.getRootCatalog()
                }
            }
                .onSuccess(::updateSuccess)
                .onFailure(::updateError)
        }
    }

    private fun reload() {
        loadData()
    }

    override fun onDestroy() {
        scope.cancel()
    }

    private fun onClick(state: NavItemComponent.State) {
        val data = state.data
        if (data != null && data is RootCatalogModel) {
            rootRouter.gotoTopCatalog(alias = data.alias)
        }
    }
}