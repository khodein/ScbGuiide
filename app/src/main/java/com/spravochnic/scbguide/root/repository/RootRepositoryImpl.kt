package com.spravochnic.scbguide.root.repository

import com.spravochnic.scbguide.catalog.db.CatalogDao
import com.spravochnic.scbguide.root.db.status.StatusDao
import com.spravochnic.scbguide.rootcatalog.db.RootCatalogDao

class RootRepositoryImpl(
    private val statusDao: StatusDao,
    private val rootCatalogDao: RootCatalogDao,
    private val catalogDao: CatalogDao,
) : RootRepository {

    override suspend fun validateStatus() {
        return Unit
    }
}