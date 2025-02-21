package com.spravochnic.scbguide.catalogroot.impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.catalogroot.api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalogroot.api.module.RootCatalogModule
import com.spravochnic.scbguide.catalogroot.impl.handler.RootCatalogHandler
import com.spravochnic.scbguide.status.api.module.StatusModule
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DefaultRootCatalogComponent(
    private val rootCatalogModule: RootCatalogModule,
    private val statusModule: StatusModule,
    componentContext: ComponentContext,
) : RootCatalogComponent, ComponentContext by componentContext {

    private val componentScope by lazy { coroutineScope(Dispatchers.Main + SupervisorJob()) }

    override val stateValue: Value<RootCatalogComponent.State> by lazy { rootCatalogHandler.stateValue }

    override val initialState by lazy {
        stateKeeper.consume(
            key = RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER,
            strategy = RootCatalogComponent.State.serializer()
        ) ?: RootCatalogComponent.State.Request(RequestComponent.State.Loading())
    }

    private val rootCatalogHandler = retainedInstance {
        RootCatalogHandler(
            initialState = initialState,
            scope = componentScope,
            rootCatalogRepository = rootCatalogModule.getRootCatalogRepository(),
            rootCatalogStateMapper = rootCatalogModule.getRootCatalogStateMapper(),
            statusRepository = statusModule.getStatusRepository(),
            rootRouter = rootCatalogModule.getRouter(),
        )
    }

    private companion object {
        const val RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER =
            "RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER"
    }
}