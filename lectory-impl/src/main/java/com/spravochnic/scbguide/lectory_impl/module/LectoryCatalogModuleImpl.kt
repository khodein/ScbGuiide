package com.spravochnic.scbguide.lectory_impl.module

import com.spravochnic.scbguide.lectory_api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.lectory_api.module.LectoryCatalogModule
import com.spravochnic.scbguide.lectory_api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.lectory_impl.repository.LectoryCatalogRepositoryImpl
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