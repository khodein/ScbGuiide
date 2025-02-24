package com.spravochnic.scbguide.main.module

import com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalog_top_api.component.TopCatalogComponent
import com.spravochnic.scbguide.splash_api.component.SplashComponent

sealed class ChildComponent {
    class RootCatalogChild(val component: RootCatalogComponent) : ChildComponent()
    class SplashChild(val component: SplashComponent) : ChildComponent()
    class TopCatalogChild(val component: TopCatalogComponent) : ChildComponent()
}