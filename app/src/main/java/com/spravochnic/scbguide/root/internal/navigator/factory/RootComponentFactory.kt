package com.spravochnic.scbguide.root.internal.navigator.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.internal.component.DefaultCatalogComponent
import com.spravochnic.scbguide.catalog.internal.repository.CatalogRepositoryImpl
import com.spravochnic.scbguide.db.ScbDatabase
import com.spravochnic.scbguide.root.api.config.RootConfig
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.api.factory.RootCatalogFactory
import com.spravochnic.scbguide.rootcatalog.internal.factory.RootCatalogFactoryImpl
import com.spravochnic.scbguide.splash.api.component.SplashComponent
import com.spravochnic.scbguide.splash.internal.component.DefaultSplashComponent
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
                    rootCatalogAlias = config.alias,
                    componentContext = componentContext
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
        val factory: RootCatalogFactory = RootCatalogFactoryImpl(
            componentContext = componentContext,
            statusDao = statusDao,
            catalogDao = catalogDao,
            rootNavigator = rootNavigator,
            rootCatalogDao = rootCatalogDao,
            resManager = resManager
        )
        return factory.get()
    }

    private fun getCatalogComponent(
        rootCatalogAlias: String,
        componentContext: ComponentContext
    ): CatalogComponent {
        return DefaultCatalogComponent(
            componentContext = componentContext,
            resManager = resManager,
            rootNavigator = rootNavigator,
            rootCatalogAlias = rootCatalogAlias,
            catalogRepository = CatalogRepositoryImpl(
                catalogDao = catalogDao
            )
        )
    }
}