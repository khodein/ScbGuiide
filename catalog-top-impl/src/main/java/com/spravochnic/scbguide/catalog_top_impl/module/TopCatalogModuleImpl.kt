package com.spravochnic.scbguide.catalog_top_impl.module

import com.spravochnic.scbguide.catalog_top_api.module.TopCatalogModule
import com.spravochnic.scbguide.catalog_top_api.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.catalog_top_impl.mapper.TopCatalogStateMapperImpl
import com.spravochnic.scbguide.root_api.module.RootModule

class TopCatalogModuleImpl(
    private val rootModule: RootModule,
) : TopCatalogModule, RootModule by rootModule {

    override fun getTopCatalogStateMapper(): TopCatalogStateMapper {
        return TopCatalogStateMapperImpl(getResManager())
    }
}