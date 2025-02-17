package com.spravochnic.scbguide.rootcatalog

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.root.navigator.RootNavigator
import com.spravochnic.scbguide.root.repository.RootRepository
import com.spravochnic.scbguide.rootcatalog.delegate.DefaultRootCatalogDelegate
import com.spravochnic.scbguide.rootcatalog.mapper.RootCatalogComponentMapperImpl
import com.spravochnic.scbguide.rootcatalog.repository.RootCatalogRepository
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

    override val stateValue: Value<RootCatalogComponent.State> by lazy { rootCatalogDelegate.stateValue }

    override val initialState by lazy {
        stateKeeper.consume(
            key = RETAINED_SAVED_INSTANCE_ROOT_CATALOG_DELEGATE,
            strategy = RootCatalogComponent.State.serializer()
        ) ?: RootCatalogComponent.State.Request(RequestComponent.State.Loading())
    }

    private val rootCatalogDelegate = retainedInstance {
        DefaultRootCatalogDelegate(
            initialState = initialState,
            scope = componentScope,
            rootCatalogRepository = rootCatalogRepository,
            rootCatalogComponentMapper = RootCatalogComponentMapperImpl(resManager = resManager),
            rootRepository = rootRepository,
            rootNavigator = rootNavigator,
        )
    }

    private companion object {
        const val RETAINED_SAVED_INSTANCE_ROOT_CATALOG_DELEGATE =
            "RETAINED_SAVED_INSTANCE_ROOT_CATALOG_DELEGATE"
    }
}