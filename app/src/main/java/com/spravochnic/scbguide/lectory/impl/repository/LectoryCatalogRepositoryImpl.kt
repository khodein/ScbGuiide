package com.spravochnic.scbguide.lectory.impl.repository

import com.spravochnic.scbguide.lectory.api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.lectory.api.model.TopLectoryCatalogModel
import com.spravochnic.scbguide.lectory.api.model.TopLectoryCatalogTypeModel
import com.spravochnic.scbguide.lectory.api.repository.LectoryCatalogRepository
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