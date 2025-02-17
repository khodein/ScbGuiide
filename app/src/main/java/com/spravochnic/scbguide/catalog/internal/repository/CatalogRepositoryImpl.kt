package com.spravochnic.scbguide.catalog.internal.repository

import com.spravochnic.scbguide.catalog.api.db.CatalogDao
import com.spravochnic.scbguide.catalog.api.repository.CatalogRepository

class CatalogRepositoryImpl(
    private val catalogDao: CatalogDao,
) : CatalogRepository {
}