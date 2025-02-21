package com.spravochnic.scbguide.root_api.config

import com.arkivanov.decompose.router.stack.StackNavigation
import com.spravochnic.scbguide.catalogroot.api.router.RootCatalogRooter
import com.spravochnic.scbguide.catalogtop.api.navigator.TopCatalogRouter

interface RootRouter :
    RootCatalogRooter,
    TopCatalogRouter {

    fun init(parent: StackNavigation<RootConfig>)

    fun pushNew(config: RootConfig)
    fun replaceCurrent(config: RootConfig)

    fun pop()
    fun pop(toIndex: Int)
}