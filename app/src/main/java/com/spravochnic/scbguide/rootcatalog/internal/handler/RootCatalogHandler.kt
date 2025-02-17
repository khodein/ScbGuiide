package com.spravochnic.scbguide.rootcatalog.internal.handler

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.root.api.repository.RootRepository
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogListModel
import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogModel
import com.spravochnic.scbguide.rootcatalog.api.repository.RootCatalogRepository
import com.spravochnic.scbguide.rootcatalog.internal.mapper.RootCatalogStateMapper
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
    private val rootNavigator: RootNavigator,
    private val rootCatalogStateMapper: RootCatalogStateMapper,
    private val rootRepository: RootRepository,
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

                    async { rootRepository.validateStatus() }.await()

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
            rootNavigator.gotoCatalog(alias = data.alias)
        }
    }
}