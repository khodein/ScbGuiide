package com.spravochnic.scbguide.catalog_root_api.repository

import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel

interface RootCatalogRepository {
    suspend fun getRootCatalog(): RootCatalogListModel
}