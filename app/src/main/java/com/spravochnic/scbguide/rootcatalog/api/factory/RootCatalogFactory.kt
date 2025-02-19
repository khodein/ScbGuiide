package com.spravochnic.scbguide.rootcatalog.api.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent

interface RootCatalogFactory {
    fun get(componentContext: ComponentContext): RootCatalogComponent
}