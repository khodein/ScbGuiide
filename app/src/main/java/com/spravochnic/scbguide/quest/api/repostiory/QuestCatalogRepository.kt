package com.spravochnic.scbguide.quest.api.repostiory

import com.spravochnic.scbguide.quest.api.model.QuestCatalogModel

interface QuestCatalogRepository {
    suspend fun getQuestCatalog(): List<QuestCatalogModel>
}