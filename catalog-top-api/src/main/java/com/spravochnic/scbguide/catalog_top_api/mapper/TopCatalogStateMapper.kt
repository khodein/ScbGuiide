package com.spravochnic.scbguide.catalog_top_api.mapper

import com.spravochnic.scbguide.catalog_top_api.component.TopCatalogComponent
import com.spravochnic.scbguide.lectory.api.model.TopLectoryCatalogModel
import com.spravochnic.scbguide.quest.api.model.TopQuestCatalogModel
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent

interface TopCatalogStateMapper {
    fun mapCatalog(
        list: List<TopLectoryCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)? = null,
    ): TopCatalogComponent.Child.NavItemChild

    fun mapQuestCatalog(
        list: List<TopQuestCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)? = null,
    ): TopCatalogComponent.Child.NavItemChild

    fun mapToolbarCatalog(
        onClickArrow: () -> Unit
    ): TopCatalogComponent.ToolbarChild

    fun mapToolbarQuestCatalog(
        onClickArrow: () -> Unit
    ): TopCatalogComponent.ToolbarChild
}