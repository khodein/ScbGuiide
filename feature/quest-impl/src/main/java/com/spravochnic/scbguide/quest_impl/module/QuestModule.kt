package com.spravochnic.scbguide.quest_impl.module

import com.spravochnic.scbguide.quest_api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.quest_impl.repository.QuestCatalogRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val questModule = module {
    singleOf(::QuestCatalogRepositoryImpl) { bind<QuestCatalogRepository>() }
}