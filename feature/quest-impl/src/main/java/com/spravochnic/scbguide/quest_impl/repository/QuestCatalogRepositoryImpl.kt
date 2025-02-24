package com.spravochnic.scbguide.quest_impl.repository

import com.spravochnic.scbguide.quest_api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.quest_api.model.TopQuestCatalogModel
import com.spravochnic.scbguide.quest_api.repostiory.QuestCatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuestCatalogRepositoryImpl(
    private val topQuestCatalogDao: TopQuestCatalogDao,
) : QuestCatalogRepository {

    override suspend fun getTopCatalog(): List<TopQuestCatalogModel> {
        return withContext(Dispatchers.IO) {
            getMock()
        }
    }

    private fun getMock(): List<TopQuestCatalogModel> {
        return buildList(3) {

        }
    }
}