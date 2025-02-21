package com.spravochnic.scbguide.catalogroot.api.model

data class RootCatalogModel(
    val id: Int,
    val title: String,
    val subName: String,
    val alias: String,
    val type: RootCatalogTypeModel,
)