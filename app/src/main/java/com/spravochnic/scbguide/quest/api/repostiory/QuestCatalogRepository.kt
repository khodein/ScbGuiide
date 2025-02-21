package com.spravochnic.scbguide.quest.api.repostiory

import com.spravochnic.scbguide.quest.api.model.TopQuestCatalogModel

interface QuestCatalogRepository {
    suspend fun getTopCatalog(): List<TopQuestCatalogModel>
}