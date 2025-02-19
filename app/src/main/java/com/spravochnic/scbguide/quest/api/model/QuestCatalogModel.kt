package com.spravochnic.scbguide.quest.api.model

data class QuestCatalogModel(
    val id: Int,
    val name: String,
    val count: String,
    val type: QuestCatalogTypeModel,
    val complete: String,
)