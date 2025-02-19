package com.spravochnic.scbguide.catalog.internal.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.api.factory.CatalogFactory
import com.spravochnic.scbguide.catalog.api.repository.CatalogRepository
import com.spravochnic.scbguide.catalog.internal.component.DefaultCatalogComponent
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.utils.resmanager.ResManager

class CatalogFactoryImpl(
    private val catalogRepository: CatalogRepository,
    private val questCatalogRepository: QuestCatalogRepository,
    private val rootNavigator: RootNavigator,
    private val resManager: ResManager,
) : CatalogFactory {

    override fun get(
        componentContext: ComponentContext,
        alias: String
    ): CatalogComponent {
        return DefaultCatalogComponent(
            componentContext = componentContext,
            resManager = resManager,
            rootNavigator = rootNavigator,
            rootCatalogAlias = alias,
            questCatalogRepository = questCatalogRepository,
            catalogRepository = catalogRepository,
        )
    }
}