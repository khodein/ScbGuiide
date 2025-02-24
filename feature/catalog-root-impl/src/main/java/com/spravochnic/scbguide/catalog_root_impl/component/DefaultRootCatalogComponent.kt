package com.spravochnic.scbguide.catalog_root_impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalog_root_impl.handler.RootCatalogHandler
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DefaultRootCatalogComponent(
    componentContext: ComponentContext,
) : RootCatalogComponent, ComponentContext by componentContext {

    private val componentScope by lazy { coroutineScope(Dispatchers.Main + SupervisorJob()) }

    override val stateValue: Value<RootCatalogComponent.State> by lazy { rootCatalogHandler.stateValue }

    private val initialState by lazy {
        stateKeeper.consume(
            key = RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER,
            strategy = RootCatalogComponent.State.serializer()
        ) ?: RootCatalogComponent.State.Request(RequestComponent.State.Loading())
    }

    private val rootCatalogHandler = retainedInstance {
        RootCatalogHandler(
            initialState = initialState,
            scope = componentScope
        )
    }

    private companion object {
        const val RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER =
            "RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER"
    }
}