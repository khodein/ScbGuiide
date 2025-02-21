package com.spravochnic.scbguide.catalogtop.api.module

import com.spravochnic.scbguide.catalogtop.impl.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.root_api.module.RootModule

interface TopCatalogModule : RootModule {
    fun getTopCatalogStateMapper(): TopCatalogStateMapper
}