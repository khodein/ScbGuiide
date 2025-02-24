package com.spravochnic.scbguide.status_impl.repository

import com.spravochnic.scbguide.catalog_root_api.repository.RootCatalogRepository
import com.spravochnic.scbguide.lectory.api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.status_api.db.status.StatusDao
import com.spravochnic.scbguide.status_api.repository.StatusRepository

class StatusRepositoryImpl(
    private val statusDao: StatusDao,
    private val rootCatalogRepository: RootCatalogRepository,
    private val questCatalogRepository: QuestCatalogRepository,
    private val lectoryCatalogRepository: LectoryCatalogRepository,
) : StatusRepository {

    override suspend fun validateStatus() {
        return Unit
    }
}