package com.spravochnic.scbguide.lectory_api.model

data class TopLectoryCatalogModel(
    val id: String,
    val count: String,
    val name: String,
    val type: TopLectoryCatalogTypeModel,
)