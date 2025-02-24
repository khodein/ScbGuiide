package com.spravochnic.scbguide.catalog_top_api.module

import com.spravochnic.scbguide.catalog_top_api.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.root_api.module.RootModule

interface TopCatalogModule : RootModule {
    fun getTopCatalogStateMapper(): TopCatalogStateMapper
}