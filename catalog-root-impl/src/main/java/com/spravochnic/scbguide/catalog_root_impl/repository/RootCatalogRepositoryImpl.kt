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
    private val rootCatalogDao: com.spravochnic.scbguide.catalog_root_api.db.RootCatalogDao,
    private val resManager: ResManager,
) : com.spravochnic.scbguide.catalog_root_api.repository.RootCatalogRepository {

    override suspend fun getRootCatalog(): com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel {
        return withContext(Dispatchers.IO) {
            getMock()
        }
    }

    private fun getMock(): com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel {
        return com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel(
            count = "150",
            list = listOf(
                com.spravochnic.scbguide.catalog_root_api.model.RootCatalogModel(
                    id = 0,
                    title = "Лекторий",
                    subName = "14 тем",
                    alias = "lectory",
                    type = com.spravochnic.scbguide.catalog_root_api.model.RootCatalogTypeModel.LECTORY
                ),
                com.spravochnic.scbguide.catalog_root_api.model.RootCatalogModel(
                    id = 1,
                    title = "Проверь себя",
                    subName = "3 уровня",
                    alias = "quest",
                    type = com.spravochnic.scbguide.catalog_root_api.model.RootCatalogTypeModel.LECTORY
                )
            )
        )
    }
}