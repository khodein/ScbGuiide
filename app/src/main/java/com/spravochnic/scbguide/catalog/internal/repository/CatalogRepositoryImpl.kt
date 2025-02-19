package com.spravochnic.scbguide.catalog.internal.repository

import com.spravochnic.scbguide.catalog.api.db.CatalogDao
import com.spravochnic.scbguide.catalog.api.model.CatalogModel
import com.spravochnic.scbguide.catalog.api.model.CatalogTypeModel
import com.spravochnic.scbguide.catalog.api.repository.CatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatalogRepositoryImpl(
    private val catalogDao: CatalogDao,
) : CatalogRepository {

    override suspend fun getCatalog(): List<CatalogModel> {
        return withContext(Dispatchers.IO) {
            getMock()
        }
    }

    private fun getMock(): List<CatalogModel> {
        return buildList {
            repeat(25) {
                CatalogModel(
                    id = it.toString(),
                    count = it.toString(),
                    name = "Name Catalog${it}",
                    type = CatalogTypeModel.TRAFFIC_LIGHT
                ).let(::add)
            }
        }
    }
}