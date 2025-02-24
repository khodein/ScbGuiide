package com.spravochnic.scbguide.root_api.router.topcatalog

import com.spravochnic.scbguide.root_api.router.RootRouter

interface TopCatalogRouter {
    fun init(parent: RootRouter)
    fun gotoTopCatalog(alias: String)
}