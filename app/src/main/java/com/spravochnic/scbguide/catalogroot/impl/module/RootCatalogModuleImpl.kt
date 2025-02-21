package com.spravochnic.scbguide.catalogroot.impl.module

import com.spravochnic.scbguide.catalogroot.api.module.RootCatalogModule
import com.spravochnic.scbguide.catalogroot.api.repository.RootCatalogRepository
import com.spravochnic.scbguide.catalogroot.impl.mapper.RootCatalogStateMapper
import com.spravochnic.scbguide.catalogroot.impl.mapper.RootCatalogStateMapperImpl
import com.spravochnic.scbguide.catalogroot.impl.repository.RootCatalogRepositoryImpl
import com.spravochnic.scbguide.db.dao.DaoModule
import com.spravochnic.scbguide.root_api.module.RootModule

class RootCatalogModuleImpl(
    private val rootModule: RootModule,
    private val daoModule: DaoModule,
) : RootCatalogModule, RootModule by rootModule {

    override fun getRootCatalogRepository(): RootCatalogRepository {
        return RootCatalogRepositoryImpl(
            rootCatalogDao = daoModule.getRootCatalogDao(),
            resManager = getResManager()
        )
    }

    override fun getRootCatalogStateMapper(): RootCatalogStateMapper {
        return RootCatalogStateMapperImpl(getResManager())
    }
}