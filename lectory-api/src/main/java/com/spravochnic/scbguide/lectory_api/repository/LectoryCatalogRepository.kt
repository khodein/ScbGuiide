package com.spravochnic.scbguide.lectory_api.repository

import com.spravochnic.scbguide.lectory_api.model.TopLectoryCatalogModel

interface LectoryCatalogRepository {
    suspend fun getTopCatalog(): List<TopLectoryCatalogModel>
}