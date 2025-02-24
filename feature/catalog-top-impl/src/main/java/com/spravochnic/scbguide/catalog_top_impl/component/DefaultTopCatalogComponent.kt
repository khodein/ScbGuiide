package com.spravochnic.scbguide.catalog_top_impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.catalog_top_api.component.TopCatalogComponent
import com.spravochnic.scbguide.catalog_top_impl.handler.TopCatalogHandler
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DefaultTopCatalogComponent(
    rootCatalogAlias: String,
    componentContext: ComponentContext,
) : TopCatalogComponent, ComponentContext by componentContext {

    private val componentScope by lazy { coroutineScope(Dispatchers.Main + SupervisorJob()) }

    private val rootCatalogTypeModel: RootCatalogTypeModel by lazy {
        RootCatalogTypeModel.entries.find { it.alias == rootCatalogAlias }
            ?: RootCatalogTypeModel.LECTORY
    }

    override val initialState: TopCatalogComponent.State = stateKeeper.consume(
        key = RETAINED_SAVED_INSTANCE_CATALOG_HANDLER,
        strategy = TopCatalogComponent.State.serializer()
    ) ?: TopCatalogComponent.State.Request(RequestComponent.State.Loading())

    override val toolbarStateValue: Value<TopCatalogComponent.ToolbarChild> by lazy { topCatalogHandler.toolbarValue }
    override val stateValue: Value<TopCatalogComponent.State> by lazy { topCatalogHandler.stateValue }

    private val topCatalogHandler = retainedInstance {
        TopCatalogHandler(
            rootCatalogTypeModel = rootCatalogTypeModel,
            scope = componentScope,
            initialState = initialState,
        )
    }

    private companion object {
        const val RETAINED_SAVED_INSTANCE_CATALOG_HANDLER =
            "RETAINED_SAVED_INSTANCE_CATALOG_HANDLER"
    }
}