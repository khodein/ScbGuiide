package com.spravochnic.scbguide.status.impl.repository

import com.spravochnic.scbguide.catalogroot.api.db.RootCatalogDao
import com.spravochnic.scbguide.lectory.api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.quest.api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.status.api.db.status.StatusDao
import com.spravochnic.scbguide.status.api.repository.StatusRepository

class StatusRepositoryImpl(
    private val statusDao: StatusDao,
    private val rootCatalogDao: RootCatalogDao,
    private val topLectoryCatalogDao: TopLectoryCatalogDao,
    private val topQuestCatalogDao: TopQuestCatalogDao,
) : StatusRepository {

    override suspend fun validateStatus() {
        return Unit
    }
}