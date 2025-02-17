package com.spravochnic.scbguide.rootcatalog.repository

import com.spravochnic.scbguide.rootcatalog.db.RootCatalogDao
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogListModel
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogModel
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogTypeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RootCatalogRepositoryImpl(
    private val rootCatalogDao: RootCatalogDao,
) : RootCatalogRepository {

    override suspend fun getRootCatalog(): RootCatalogListModel {
        return withContext(Dispatchers.IO) {
            getMock()
        }
    }

    private fun getMock(): RootCatalogListModel {
        return RootCatalogListModel(
            count = "150",
            list = listOf(
                RootCatalogModel(
                    id = 0,
                    title = "Лекторий",
                    subName = "14 тем",
                    alias = "lectory",
                    type = RootCatalogTypeModel.LECTORY
                ),
                RootCatalogModel(
                    id = 1,
                    title = "Проверь себя",
                    subName = "3 уровня",
                    alias = "quest",
                    type = RootCatalogTypeModel.LECTORY
                )
            )
        )
    }
}