package com.spravochnic.scbguide.catalog.internal.handler

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.api.repository.CatalogRepository
import com.spravochnic.scbguide.catalog.internal.mapper.CatalogStateMapper
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CatalogHandler(
    private val rootCatalogTypeModel: RootCatalogTypeModel,
    private val scope: CoroutineScope,
    private val rootNavigator: RootNavigator,
    private val catalogStateMapper: CatalogStateMapper,
    private val catalogRepository: CatalogRepository,
    initialState: CatalogComponent.State,
) : InstanceKeeper.Instance {

    val toolbarValue: MutableValue<ToolbarComponent.State> = MutableValue(
        catalogStateMapper.mapToolbarState(rootNavigator::pop)
    )

    val stateValue: MutableValue<CatalogComponent.State> = MutableValue(initialState)

    init {
        loadData()
    }

    private fun loadData() {
        scope.launch {

        }
    }
}