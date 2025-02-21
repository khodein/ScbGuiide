package com.spravochnic.scbguide.catalogtop.api.navigator

import com.spravochnic.scbguide.root_api.config.RootRouter

interface TopCatalogRouter {
    fun init(parent: RootRouter)
    fun gotoTopCatalog(alias: String)
}