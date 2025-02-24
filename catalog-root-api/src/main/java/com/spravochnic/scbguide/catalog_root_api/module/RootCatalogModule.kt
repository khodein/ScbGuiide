package com.spravochnic.scbguide.catalog_root_api.module

import com.spravochnic.scbguide.catalog_root_api.repository.RootCatalogRepository
import com.spravochnic.scbguide.catalogroot.impl.mapper.RootCatalogStateMapper
import com.spravochnic.scbguide.root_api.module.RootModule

interface RootCatalogModule : RootModule {
    fun getRootCatalogRepository(): RootCatalogRepository
    fun getRootCatalogStateMapper(): RootCatalogStateMapper
}