package com.spravochnic.scbguide.lectory.impl.module

import com.spravochnic.scbguide.lectory.api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.lectory.api.module.LectoryCatalogModule
import com.spravochnic.scbguide.lectory.api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.lectory.impl.repository.LectoryCatalogRepositoryImpl
import com.spravochnic.scbguide.root_api.module.RootModule

class LectoryCatalogModuleImpl(
    private val topLectoryCatalogDao: TopLectoryCatalogDao,
    private val rootModule: RootModule
) : LectoryCatalogModule, RootModule by rootModule {

    override fun getLectoryCatalogRepository(): LectoryCatalogRepository {
        return LectoryCatalogRepositoryImpl(
            topCatalogDao = topLectoryCatalogDao
        )
    }
}