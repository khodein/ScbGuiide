package com.spravochnic.scbguide.rootcatalog.internal.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.root.api.repository.RootRepository
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.api.repository.RootCatalogRepository
import com.spravochnic.scbguide.rootcatalog.internal.handler.RootCatalogHandler
import com.spravochnic.scbguide.rootcatalog.internal.mapper.RootCatalogStateMapperImpl
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DefaultRootCatalogComponent(
    resManager: ResManager,
    rootNavigator: RootNavigator,
    rootCatalogRepository: RootCatalogRepository,
    rootRepository: RootRepository,
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
            rootCatalogRepository = rootCatalogRepository,
            rootCatalogStateMapper = RootCatalogStateMapperImpl(resManager = resManager),
            rootRepository = rootRepository,
            rootNavigator = rootNavigator,
        )
    }

    private companion object {
        const val RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER =
            "RETAINED_SAVED_INSTANCE_ROOT_CATALOG_HANDLER"
    }
}