package com.spravochnic.scbguide.root.navigator.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog.CatalogComponent
import com.spravochnic.scbguide.catalog.DefaultCatalogComponent
import com.spravochnic.scbguide.catalog.repository.CatalogRepositoryImpl
import com.spravochnic.scbguide.db.ScbDatabase
import com.spravochnic.scbguide.root.navigator.RootConfig
import com.spravochnic.scbguide.root.navigator.RootNavigator
import com.spravochnic.scbguide.root.repository.RootRepositoryImpl
import com.spravochnic.scbguide.rootcatalog.DefaultRootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.repository.RootCatalogRepositoryImpl
import com.spravochnic.scbguide.splash.DefaultSplashComponent
import com.spravochnic.scbguide.splash.SplashComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager

class RootComponentFactory(
    private val rootNavigator: RootNavigator,
    private val resManager: ResManager,
    private val scbDatabase: ScbDatabase,
) {
    private val statusDao by lazy { scbDatabase.statusDao() }
    private val rootCatalogDao by lazy { scbDatabase.rootCatalogDao() }
    private val catalogDao by lazy { scbDatabase.catalogDao() }

    fun get(
        config: RootConfig,
        componentContext: ComponentContext,
    ): ChildComponent {
        return when (config) {
            is RootConfig.RootCatalog -> ChildComponent.RootCatalogChild(
                getRootCatalogComponent(
                    componentContext
                )
            )

            is RootConfig.Splash -> ChildComponent.SplashChild(
                getSplashComponent(
                    componentContext
                )
            )

            is RootConfig.Catalog -> ChildComponent.CatalogChild(
                getCatalogComponent(
                    componentContext
                )
            )
        }
    }

    private fun getSplashComponent(componentContext: ComponentContext): SplashComponent {
        return DefaultSplashComponent(
            componentContext = componentContext,
            rootNavigator = rootNavigator,
        )
    }

    private fun getRootCatalogComponent(
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

    private fun getCatalogComponent(
        componentContext: ComponentContext
    ): CatalogComponent {
        return DefaultCatalogComponent(
            componentContext = componentContext,
            resManager = resManager,
            catalogRepository = CatalogRepositoryImpl(
                catalogDao = catalogDao
            )
        )
    }
}