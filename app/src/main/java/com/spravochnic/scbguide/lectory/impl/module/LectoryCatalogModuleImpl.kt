package com.spravochnic.scbguide.lectory.impl.module

import com.spravochnic.scbguide.db.dao.DaoModule
import com.spravochnic.scbguide.lectory.api.module.LectoryCatalogModule
import com.spravochnic.scbguide.lectory.api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.lectory.impl.repository.LectoryCatalogRepositoryImpl
import com.spravochnic.scbguide.root_api.module.RootModule

class LectoryCatalogModuleImpl(
    private val daoModule: DaoModule,
    private val rootModule: RootModule
) : LectoryCatalogModule, RootModule by rootModule {

    override fun getLectoryCatalogRepository(): LectoryCatalogRepository {
        return LectoryCatalogRepositoryImpl(
            topCatalogDao = daoModule.getTopLectoryCatalogDao()
        )
    }
}