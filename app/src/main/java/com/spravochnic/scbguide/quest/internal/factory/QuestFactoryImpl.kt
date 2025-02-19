package com.spravochnic.scbguide.quest.internal.factory

import com.spravochnic.scbguide.quest.api.factory.QuestFactory
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.utils.resmanager.ResManager

class QuestFactoryImpl(
    private val resManager: ResManager,
    private val rootNavigator: RootNavigator,
    private val questCatalogRepository: QuestCatalogRepository,
) : QuestFactory {

}