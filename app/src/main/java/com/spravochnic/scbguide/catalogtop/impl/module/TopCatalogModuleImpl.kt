package com.spravochnic.scbguide.catalogtop.impl.module

import com.spravochnic.scbguide.catalogtop.api.module.TopCatalogModule
import com.spravochnic.scbguide.catalogtop.impl.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.catalogtop.impl.mapper.TopCatalogStateMapperImpl
import com.spravochnic.scbguide.root_api.module.RootModule

class TopCatalogModuleImpl(
    private val rootModule: RootModule,
) : TopCatalogModule, RootModule by rootModule {

    override fun getTopCatalogStateMapper(): TopCatalogStateMapper {
        return TopCatalogStateMapperImpl(getResManager())
    }
}