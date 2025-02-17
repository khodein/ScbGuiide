package com.spravochnic.scbguide.rootcatalog.repository

import com.spravochnic.scbguide.rootcatalog.model.RootCatalogListModel

interface RootCatalogRepository {
    suspend fun getRootCatalog(): RootCatalogListModel
}