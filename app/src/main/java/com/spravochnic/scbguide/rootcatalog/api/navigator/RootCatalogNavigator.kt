package com.spravochnic.scbguide.rootcatalog.api.navigator

import com.spravochnic.scbguide.root.api.config.RootNavigator

interface RootCatalogNavigator {
    fun init(parent: RootNavigator)
    fun replaceToRootCatalog()
}