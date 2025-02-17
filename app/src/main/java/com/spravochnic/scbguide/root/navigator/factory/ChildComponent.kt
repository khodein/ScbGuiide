package com.spravochnic.scbguide.root.navigator.factory

import com.spravochnic.scbguide.catalog.component.CatalogComponent
import com.spravochnic.scbguide.rootcatalog.component.RootCatalogComponent
import com.spravochnic.scbguide.splash.SplashComponent

sealed class ChildComponent {
    class RootCatalogChild(val component: RootCatalogComponent) : ChildComponent()
    class SplashChild(val component: SplashComponent) : ChildComponent()
    class CatalogChild(val component: CatalogComponent) : ChildComponent()
}