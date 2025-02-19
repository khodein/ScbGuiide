package com.spravochnic.scbguide.catalog.api.repository

import com.spravochnic.scbguide.catalog.api.model.CatalogModel

interface CatalogRepository {
    suspend fun getCatalog(): List<CatalogModel>
}