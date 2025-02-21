package com.spravochnic.scbguide.quest.api.module

import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.root_api.module.RootModule

interface QuestCatalogModule : RootModule {
    fun getQuestCatalogRepository(): QuestCatalogRepository
}