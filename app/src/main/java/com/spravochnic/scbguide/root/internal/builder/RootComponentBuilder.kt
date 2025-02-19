package com.spravochnic.scbguide.root.internal.builder

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog.api.factory.CatalogFactory
import com.spravochnic.scbguide.root.api.config.RootConfig
import com.spravochnic.scbguide.rootcatalog.api.factory.RootCatalogFactory
import com.spravochnic.scbguide.splash.api.factory.SplashFactory

class RootComponentBuilder(
    private val rootCatalogFactory: RootCatalogFactory,
    private val catalogFactory: CatalogFactory,
    private val splashFactory: SplashFactory,
) {
    fun get(
        config: RootConfig,
        componentContext: ComponentContext,
    ): ChildComponent {
        return when (config) {
            is RootConfig.RootCatalog -> ChildComponent.RootCatalogChild(
                rootCatalogFactory.get(componentContext)
            )

            is RootConfig.Splash -> ChildComponent.SplashChild(
                splashFactory.get(componentContext)
            )

            is RootConfig.Catalog -> ChildComponent.CatalogChild(
                catalogFactory.get(
                    componentContext = componentContext,
                    alias = config.alias
                )
            )
        }
    }
}