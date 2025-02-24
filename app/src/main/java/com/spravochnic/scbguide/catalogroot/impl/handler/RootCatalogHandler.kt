package com.spravochnic.scbguide.catalogroot.impl.handler

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.catalogroot.api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogListModel
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogModel
import com.spravochnic.scbguide.catalogroot.api.repository.RootCatalogRepository
import com.spravochnic.scbguide.catalogroot.impl.mapper.RootCatalogStateMapper
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.status.api.repository.StatusRepository
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RootCatalogHandler(
    private val rootRouter: RootRouter,
    private val rootCatalogStateMapper: RootCatalogStateMapper,
    private val statusRepository: StatusRepository,
    private val rootCatalogRepository: RootCatalogRepository,
    private val scope: CoroutineScope,
    initialState: RootCatalogComponent.State,
) : InstanceKeeper.Instance {

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