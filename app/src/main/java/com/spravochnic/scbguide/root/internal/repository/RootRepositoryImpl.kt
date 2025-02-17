package com.spravochnic.scbguide.root.internal.repository

import com.spravochnic.scbguide.catalog.api.db.CatalogDao
import com.spravochnic.scbguide.root.api.db.status.StatusDao
import com.spravochnic.scbguide.root.api.repository.RootRepository
import com.spravochnic.scbguide.rootcatalog.api.db.RootCatalogDao

class RootRepositoryImpl(
    private val statusDao: StatusDao,
    private val rootCatalogDao: RootCatalogDao,
    private val catalogDao: CatalogDao,
) : RootRepository {

    override suspend fun validateStatus() {
        return Unit
    }
}