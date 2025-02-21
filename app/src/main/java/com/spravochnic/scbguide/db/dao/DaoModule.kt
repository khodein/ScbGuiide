package com.spravochnic.scbguide.db.dao

import com.spravochnic.scbguide.catalogroot.api.db.RootCatalogDao
import com.spravochnic.scbguide.lectory.api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.quest.api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.status.api.db.status.StatusDao

interface DaoModule {
    fun getStatusDao(): StatusDao
    fun getRootCatalogDao(): RootCatalogDao
    fun getTopLectoryCatalogDao(): TopLectoryCatalogDao
    fun getTopQuestCatalogDao(): TopQuestCatalogDao
}