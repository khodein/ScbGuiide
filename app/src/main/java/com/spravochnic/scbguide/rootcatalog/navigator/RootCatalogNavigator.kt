package com.spravochnic.scbguide.rootcatalog.navigator

import com.spravochnic.scbguide.root.navigator.RootNavigator

interface RootCatalogNavigator {
    fun init(parent: RootNavigator)
    fun replaceToRootCatalog()
}