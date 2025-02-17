package com.spravochnic.scbguide.root.navigator.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog.component.CatalogComponent
import com.spravochnic.scbguide.catalog.component.DefaultCatalogComponent
import com.spravochnic.scbguide.db.ScbDatabase
import com.spravochnic.scbguide.root.navigator.RootConfig
import com.spravochnic.scbguide.root.navigator.RootNavigator
import com.spravochnic.scbguide.root.repository.RootRepositoryImpl
import com.spravochnic.scbguide.rootcatalog.component.DefaultRootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.repository.RootCatalogRepositoryImpl
import com.spravochnic.scbguide.splash.DefaultSplashComponent
import com.spravochnic.scbguide.splash.SplashComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager

class RootComponentFactory(
    private val rootNavigator: RootNavigator,
    private val resManager: ResManager,
    private val scbDatabase: ScbDatabase,
) {

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

            is RootConfig.Splash -> ChildComponent.SplashChild(getSplashComponent(componentContext))

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
        val rootCatalogDao = scbDatabase.rootCatalogDao()

        return DefaultRootCatalogComponent(
            componentContext = componentContext,
            rootCatalogRepository = RootCatalogRepositoryImpl(
                rootCatalogDao = rootCatalogDao
            ),
            rootRepository = RootRepositoryImpl(
                statusDao = scbDatabase.statusDao(),
                rootCatalogDao = rootCatalogDao
            ),
            rootNavigator = rootNavigator,
            resManager = resManager,
        )
    }

    private fun getCatalogComponent(
        componentContext: ComponentContext
    ): CatalogComponent {
        return DefaultCatalogComponent(componentContext)
    }
}