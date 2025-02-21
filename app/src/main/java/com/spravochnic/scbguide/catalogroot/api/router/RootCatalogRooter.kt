package com.spravochnic.scbguide.catalogroot.api.router

import com.spravochnic.scbguide.root_api.config.RootRouter

interface RootCatalogRooter {
    fun init(parent: RootRouter)
    fun replaceToRootCatalog()
}