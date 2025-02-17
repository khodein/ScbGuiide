package com.spravochnic.scbguide.root.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.spravochnic.scbguide.catalog.navigator.CatalogNavigator
import com.spravochnic.scbguide.rootcatalog.navigator.RootCatalogNavigator

interface RootNavigator :
    RootCatalogNavigator,
    CatalogNavigator {

    fun init(parent: StackNavigation<RootConfig>)

    fun pushNew(config: RootConfig)
    fun replaceCurrent(config: RootConfig)

    fun pop()
    fun pop(toIndex: Int)
}