package com.spravochnic.scbguide.quest.impl.module

import com.spravochnic.scbguide.db.dao.DaoModule
import com.spravochnic.scbguide.quest.api.module.QuestCatalogModule
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.quest.impl.repository.QuestCatalogRepositoryImpl
import com.spravochnic.scbguide.root_api.module.RootModule

class QuestCatalogModuleImpl(
    private val daoModule: DaoModule,
    private val rootModule: RootModule
) : QuestCatalogModule, RootModule by rootModule {

    override fun getQuestCatalogRepository(): QuestCatalogRepository {
        return QuestCatalogRepositoryImpl(
            topQuestCatalogDao = daoModule.getTopQuestCatalogDao()
        )
    }
}