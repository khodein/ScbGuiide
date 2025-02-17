package com.spravochnic.scbguide.rootcatalog.model

data class RootCatalogModel(
    val id: Int,
    val title: String,
    val subName: String,
    val alias: String,
    val type: RootCatalogTypeModel,
)