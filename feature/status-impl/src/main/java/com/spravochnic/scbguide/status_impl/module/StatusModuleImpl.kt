package com.spravochnic.scbguide.status_impl.module

import com.spravochnic.scbguide.catalog_root_api.module.RootCatalogModule
import com.spravochnic.scbguide.lectory_api.module.LectoryCatalogModule
import com.spravochnic.scbguide.quest_api.module.QuestCatalogModule
import com.spravochnic.scbguide.root_api.module.RootModule
import com.spravochnic.scbguide.status_api.db.status.StatusDao
import com.spravochnic.scbguide.status_api.module.StatusModule
import com.spravochnic.scbguide.status_api.repository.StatusRepository
import com.spravochnic.scbguide.status_impl.repository.StatusRepositoryImpl

class StatusModuleImpl(
    private val statusDao: StatusDao,
    private val questCatalogModule: QuestCatalogModule,
    private val lectoryCatalogModule: LectoryCatalogModule,
    private val rootCatalogModule: RootCatalogModule,
    rootModule: RootModule,
) : StatusModule, RootModule by rootModule {

    override fun getStatusRepository(): StatusRepository {
        return StatusRepositoryImpl(
            statusDao = statusDao,
            questCatalogRepository = questCatalogModule.getQuestCatalogRepository(),
            lectoryCatalogRepository = lectoryCatalogModule.getLectoryCatalogRepository(),
            rootCatalogRepository = rootCatalogModule.getRootCatalogRepository()
        )
    }
}