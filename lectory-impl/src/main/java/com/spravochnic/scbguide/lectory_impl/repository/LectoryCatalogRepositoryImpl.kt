package com.spravochnic.scbguide.lectory_impl.repository

import com.spravochnic.scbguide.lectory_api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.lectory_api.model.TopLectoryCatalogModel
import com.spravochnic.scbguide.lectory_api.model.TopLectoryCatalogTypeModel
import com.spravochnic.scbguide.lectory_api.repository.LectoryCatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LectoryCatalogRepositoryImpl(
    private val topCatalogDao: TopLectoryCatalogDao,
) : LectoryCatalogRepository {

    override suspend fun getTopCatalog(): List<TopLectoryCatalogModel> {
        return withContext(Dispatchers.IO) {
            getMock()
        }
    }

    private fun getMock(): List<TopLectoryCatalogModel> {
        return buildList {
            repeat(25) {
                TopLectoryCatalogModel(
                    id = it.toString(),
                    count = it.toString(),
                    name = "Name Catalog${it}",
                    type = TopLectoryCatalogTypeModel.TRAFFIC_LIGHT
                ).let(::add)
            }
        }
    }
}