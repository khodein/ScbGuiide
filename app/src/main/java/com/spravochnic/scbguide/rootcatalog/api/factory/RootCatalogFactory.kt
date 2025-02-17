package com.spravochnic.scbguide.rootcatalog.api.factory

import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent

interface RootCatalogFactory {
    fun get(): RootCatalogComponent
}