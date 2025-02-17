package com.spravochnic.scbguide.root.api.config

import com.arkivanov.decompose.router.stack.StackNavigation
import com.spravochnic.scbguide.catalog.api.navigator.CatalogNavigator
import com.spravochnic.scbguide.rootcatalog.api.navigator.RootCatalogNavigator

interface RootNavigator :
    RootCatalogNavigator,
    CatalogNavigator {

    fun init(parent: StackNavigation<RootConfig>)

    fun pushNew(config: RootConfig)
    fun replaceCurrent(config: RootConfig)

    fun pop()
    fun pop(toIndex: Int)
}