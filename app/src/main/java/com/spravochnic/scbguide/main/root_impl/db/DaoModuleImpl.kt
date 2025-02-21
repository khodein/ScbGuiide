package com.spravochnic.scbguide.main.root_impl.db

import com.spravochnic.scbguide.catalogroot.api.db.RootCatalogDao
import com.spravochnic.scbguide.db.ScbDatabase
import com.spravochnic.scbguide.db.dao.DaoModule
import com.spravochnic.scbguide.lectory.api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.quest.api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.status.api.db.status.StatusDao

class DaoModuleImpl(
    private val db: ScbDatabase
) : DaoModule {

    override fun getStatusDao(): StatusDao {
        return db.statusDao()
    }

    override fun getRootCatalogDao(): RootCatalogDao {
        return db.rootCatalogDao()
    }

    override fun getTopLectoryCatalogDao(): TopLectoryCatalogDao {
        return db.topLectoryCatalogDao()
    }

    override fun getTopQuestCatalogDao(): TopQuestCatalogDao {
        return db.topQuestCatalogDao()
    }
}