package com.spravochnic.scbguide.root_api.router

import com.arkivanov.decompose.router.stack.StackNavigation
import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.router.catalog.RootCatalogRooter
import com.spravochnic.scbguide.root_api.router.topcatalog.TopCatalogRouter

interface RootRouter :
    RootCatalogRooter,
    TopCatalogRouter {

    fun init(parent: StackNavigation<RootConfig>)

    fun pushNew(config: RootConfig)
    fun replaceCurrent(config: RootConfig)

    fun pop()
    fun pop(toIndex: Int)
}