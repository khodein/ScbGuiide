package com.spravochnic.scbguide.root_api.router.catalog

import com.spravochnic.scbguide.root_api.router.RootRouter

interface RootCatalogRooter {
    fun init(parent: RootRouter)
    fun replaceToRootCatalog()
}