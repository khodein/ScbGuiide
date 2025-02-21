package com.spravochnic.scbguide.main.root_impl.module

import com.spravochnic.scbguide.catalogroot.api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalogtop.api.component.TopCatalogComponent
import com.spravochnic.scbguide.splash.api.component.SplashComponent

sealed class ChildComponent {
    class RootCatalogChild(val component: RootCatalogComponent) : ChildComponent()
    class SplashChild(val component: SplashComponent) : ChildComponent()
    class TopCatalogChild(val component: TopCatalogComponent) : ChildComponent()
}