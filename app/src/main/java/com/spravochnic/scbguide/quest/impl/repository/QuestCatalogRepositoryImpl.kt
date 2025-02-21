package com.spravochnic.scbguide.quest.impl.repository

import com.spravochnic.scbguide.quest.api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.quest.api.model.TopQuestCatalogModel
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
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