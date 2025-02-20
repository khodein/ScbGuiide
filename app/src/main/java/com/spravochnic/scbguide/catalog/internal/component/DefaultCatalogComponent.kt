package com.spravochnic.scbguide.catalog.internal.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.api.repository.CatalogRepository
import com.spravochnic.scbguide.catalog.internal.handler.CatalogHandler
import com.spravochnic.scbguide.catalog.internal.mapper.CatalogStateMapperImpl
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DefaultCatalogComponent(
    rootCatalogAlias: String,
    catalogRepository: CatalogRepository,
    questCatalogRepository: QuestCatalogRepository,
    rootNavigator: RootNavigator,
    resManager: ResManager,
    componentContext: ComponentContext,
) : CatalogComponent, ComponentContext by componentContext {

    private val componentScope by lazy { coroutineScope(Dispatchers.Main + SupervisorJob()) }

    private val rootCatalogTypeModel: RootCatalogTypeModel by lazy {
        RootCatalogTypeModel.entries.find { it.alias == rootCatalogAlias }
            ?: RootCatalogTypeModel.LECTORY
    }

    override val initialState: CatalogComponent.State = stateKeeper.consume(
        key = RETAINED_SAVED_INSTANCE_CATALOG_HANDLER,
        strategy = CatalogComponent.State.serializer()
    ) ?: CatalogComponent.State.Request(RequestComponent.State.Loading())

    override val toolbarStateValue: Value<CatalogComponent.ToolbarChild> by lazy { catalogHandler.toolbarValue }
    override val stateValue: Value<CatalogComponent.State> by lazy { catalogHandler.stateValue }

    private val catalogHandler = retainedInstance {
        CatalogHandler(
            rootCatalogTypeModel = rootCatalogTypeModel,
            scope = componentScope,
            catalogRepository = catalogRepository,
            rootNavigator = rootNavigator,
            catalogStateMapper = CatalogStateMapperImpl(resManager),
            questCatalogRepository = questCatalogRepository,
            initialState = initialState,
        )
    }

    private companion object {
        const val RETAINED_SAVED_INSTANCE_CATALOG_HANDLER =
            "RETAINED_SAVED_INSTANCE_CATALOG_HANDLER"
    }
}