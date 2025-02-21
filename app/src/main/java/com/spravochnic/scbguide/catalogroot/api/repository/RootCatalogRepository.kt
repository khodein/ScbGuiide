package com.spravochnic.scbguide.catalogroot.api.repository

import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogListModel

interface RootCatalogRepository {
    suspend fun getRootCatalog(): RootCatalogListModel
}