package com.spravochnic.scbguide.catalog_root_api.model

data class RootCatalogModel(
    val id: Int,
    val title: String,
    val subName: String,
    val alias: String,
    val type: RootCatalogTypeModel,
)