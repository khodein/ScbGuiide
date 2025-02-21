package com.spravochnic.scbguide.quest.api.model

data class TopQuestCatalogModel(
    val id: Int,
    val name: String,
    val count: String,
    val type: TopQuestCatalogTypeModel,
    val complete: String,
)