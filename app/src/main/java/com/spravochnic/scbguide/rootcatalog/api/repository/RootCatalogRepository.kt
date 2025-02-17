package com.spravochnic.scbguide.rootcatalog.api.repository

import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogListModel

interface RootCatalogRepository {
    suspend fun getRootCatalog(): RootCatalogListModel
}