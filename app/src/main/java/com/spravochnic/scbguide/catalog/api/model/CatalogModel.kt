package com.spravochnic.scbguide.catalog.api.model

data class CatalogModel(
    val id: String,
    val count: String,
    val name: String,
    val type: CatalogTypeModel,
)