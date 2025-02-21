package com.spravochnic.scbguide.catalogtop.impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.catalogtop.api.component.TopCatalogComponent
import com.spravochnic.scbguide.catalogtop.api.module.TopCatalogModule
import com.spravochnic.scbguide.catalogtop.impl.handler.TopCatalogHandler
import com.spravochnic.scbguide.lectory.api.module.LectoryCatalogModule
import com.spravochnic.scbguide.quest.api.module.QuestCatalogModule
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DefaultTopCatalogComponent(
    topCatalogModule: TopCatalogModule,
    lectoryCatalogModule: LectoryCatalogModule,
    questCatalogModule: QuestCatalogModule,
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
            lectoryCatalogRepository = lectoryCatalogModule.getLectoryCatalogRepository(),
            questCatalogRepository = questCatalogModule.getQuestCatalogRepository(),
            rootRouter = topCatalogModule.getRouter(),
            topCatalogStateMapper = topCatalogModule.getTopCatalogStateMapper(),
            initialState = initialState,
        )
    }

    private companion object {
        const val RETAINED_SAVED_INSTANCE_CATALOG_HANDLER =
            "RETAINED_SAVED_INSTANCE_CATALOG_HANDLER"
    }
}