package com.spravochnic.scbguide.quest.internal.repository

import com.spravochnic.scbguide.quest.api.db.catalog.QuestCatalogDao
import com.spravochnic.scbguide.quest.api.model.QuestCatalogModel
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuestCatalogRepositoryImpl(
    private val questCatalogDao: QuestCatalogDao,
) : QuestCatalogRepository {

    override suspend fun getQuestCatalog(): List<QuestCatalogModel> {
        return withContext(Dispatchers.IO) {
            getMock()
        }
    }

    private fun getMock(): List<QuestCatalogModel> {
        return emptyList()
    }
}