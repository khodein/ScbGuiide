package com.spravochnic.scbguide.quest_api.model

data class TopQuestCatalogModel(
    val id: Int,
    val name: String,
    val count: String,
    val type: TopQuestCatalogTypeModel,
    val complete: String,
)