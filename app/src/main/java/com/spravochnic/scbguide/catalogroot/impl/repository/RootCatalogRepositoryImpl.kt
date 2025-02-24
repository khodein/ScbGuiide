package com.spravochnic.scbguide.catalogroot.impl.repository

import com.spravochnic.scbguide.catalogroot.api.db.RootCatalogDao
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogListModel
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogModel
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.catalogroot.api.repository.RootCatalogRepository
import com.spravochnic.scbguide.root_api.utils.ResManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RootCatalogRepositoryImpl(
    private val rootCatalogDao: RootCatalogDao,
    private val resManager: ResManager,
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