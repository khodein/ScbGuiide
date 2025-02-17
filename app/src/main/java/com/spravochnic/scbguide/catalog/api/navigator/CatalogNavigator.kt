package com.spravochnic.scbguide.catalog.api.navigator

import com.spravochnic.scbguide.root.api.config.RootNavigator

interface CatalogNavigator {
    fun init(parent: RootNavigator)
    fun gotoCatalog(alias: String)
}