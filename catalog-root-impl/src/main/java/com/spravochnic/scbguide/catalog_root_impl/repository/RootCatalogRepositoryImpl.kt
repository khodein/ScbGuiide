package com.spravochnic.scbguide.catalog_root_impl.repository

import com.spravochnic.scbguide.catalog_root_api.db.RootCatalogDao
import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel
import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogModel
import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.catalog_root_api.repository.RootCatalogRepository
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