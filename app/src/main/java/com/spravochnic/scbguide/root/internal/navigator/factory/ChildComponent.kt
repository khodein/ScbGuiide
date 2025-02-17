package com.spravochnic.scbguide.root.internal.navigator.factory

import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.splash.api.component.SplashComponent

sealed class ChildComponent {
    class RootCatalogChild(val component: RootCatalogComponent) : ChildComponent()
    class SplashChild(val component: SplashComponent) : ChildComponent()
    class CatalogChild(val component: CatalogComponent) : ChildComponent()
}