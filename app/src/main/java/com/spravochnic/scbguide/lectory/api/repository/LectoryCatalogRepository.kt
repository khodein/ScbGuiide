package com.spravochnic.scbguide.lectory.api.repository

import com.spravochnic.scbguide.lectory.api.model.TopLectoryCatalogModel

interface LectoryCatalogRepository {
    suspend fun getTopCatalog(): List<TopLectoryCatalogModel>
}