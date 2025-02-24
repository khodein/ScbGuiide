package com.spravochnic.scbguide.quest_api.repostiory

import com.spravochnic.scbguide.quest_api.model.TopQuestCatalogModel

interface QuestCatalogRepository {
    suspend fun getTopCatalog(): List<TopQuestCatalogModel>
}