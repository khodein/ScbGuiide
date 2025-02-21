package com.spravochnic.scbguide.status.impl.module

import com.spravochnic.scbguide.db.dao.DaoModule
import com.spravochnic.scbguide.root_api.module.RootModule
import com.spravochnic.scbguide.status.api.module.StatusModule
import com.spravochnic.scbguide.status.api.repository.StatusRepository
import com.spravochnic.scbguide.status.impl.repository.StatusRepositoryImpl

class StatusModuleImpl(
    private val daoModule: DaoModule,
    rootModule: RootModule,
) : StatusModule, RootModule by rootModule {

    override fun getStatusRepository(): StatusRepository {
        return StatusRepositoryImpl(
            statusDao = daoModule.getStatusDao(),
            rootCatalogDao = daoModule.getRootCatalogDao(),
            topQuestCatalogDao = daoModule.getTopQuestCatalogDao(),
            topLectoryCatalogDao = daoModule.getTopLectoryCatalogDao(),
        )
    }
}