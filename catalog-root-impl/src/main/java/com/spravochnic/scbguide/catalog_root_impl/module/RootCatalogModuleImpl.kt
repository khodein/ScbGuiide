package com.spravochnic.scbguide.catalog_root_impl.module

import com.spravochnic.scbguide.catalog_root_api.db.RootCatalogDao
import com.spravochnic.scbguide.catalog_root_api.module.RootCatalogModule
import com.spravochnic.scbguide.catalog_root_api.repository.RootCatalogRepository
import com.spravochnic.scbguide.catalog_root_impl.mapper.RootCatalogStateMapper
import com.spravochnic.scbguide.catalog_root_impl.mapper.RootCatalogStateMapperImpl
import com.spravochnic.scbguide.catalog_root_impl.repository.RootCatalogRepositoryImpl
import com.spravochnic.scbguide.root_api.module.RootModule

class RootCatalogModuleImpl(
    private val rootCatalogDao: RootCatalogDao,
    private val rootModule: RootModule,
) : RootCatalogModule, RootModule by rootModule {

    override fun getRootCatalogRepository(): RootCatalogRepository {
        return RootCatalogRepositoryImpl(
            rootCatalogDao = rootCatalogDao,
            resManager = getResManager()
        )
    }

    override fun getRootCatalogStateMapper(): RootCatalogStateMapper {
        return RootCatalogStateMapperImpl(getResManager())
    }
}