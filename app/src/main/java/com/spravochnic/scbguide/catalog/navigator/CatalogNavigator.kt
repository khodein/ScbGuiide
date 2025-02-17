package com.spravochnic.scbguide.catalog.navigator

import com.spravochnic.scbguide.root.navigator.RootNavigator

interface CatalogNavigator {
    fun init(parent: RootNavigator)
    fun gotoCatalog(alias: String)
}