package com.spravochnic.scbguide.catalog.repository

import com.spravochnic.scbguide.catalog.db.CatalogDao

class CatalogRepositoryImpl(
    private val catalogDao: CatalogDao,
) : CatalogRepository {
}