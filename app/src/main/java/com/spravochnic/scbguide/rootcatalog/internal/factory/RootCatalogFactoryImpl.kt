package com.spravochnic.scbguide.rootcatalog.internal.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog.api.db.CatalogDao
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.root.api.db.status.StatusDao
import com.spravochnic.scbguide.root.internal.repository.RootRepositoryImpl
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.api.db.RootCatalogDao
import com.spravochnic.scbguide.rootcatalog.api.factory.RootCatalogFactory
import com.spravochnic.scbguide.rootcatalog.internal.component.DefaultRootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.internal.repository.RootCatalogRepositoryImpl
import com.spravochnic.scbguide.utils.resmanager.ResManager

class RootCatalogFactoryImpl(
    private val statusDao: StatusDao,
    private val rootNavigator: RootNavigator,
    private val catalogDao: CatalogDao,
    private val rootCatalogDao: RootCatalogDao,
    private val resManager: ResManager,
) : RootCatalogFactory {

    override fun get(
        componentContext: ComponentContext,
    ): RootCatalogComponent {
        return DefaultRootCatalogComponent(
            componentContext = componentContext,
            rootCatalogRepository = RootCatalogRepositoryImpl(
                rootCatalogDao = rootCatalogDao,
                resManager = resManager
            ),
            rootRepository = RootRepositoryImpl(
                statusDao = statusDao,
                rootCatalogDao = rootCatalogDao,
                catalogDao = catalogDao,
            ),
            rootNavigator = rootNavigator,
            resManager = resManager,
        )
    }
}