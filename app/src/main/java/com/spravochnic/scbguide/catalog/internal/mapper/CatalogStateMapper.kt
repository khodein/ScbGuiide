package com.spravochnic.scbguide.catalog.internal.mapper

import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.api.model.CatalogModel
import com.spravochnic.scbguide.quest.api.model.QuestCatalogModel
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent

interface CatalogStateMapper {
    fun mapCatalog(
        list: List<CatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)? = null,
    ): CatalogComponent.Child.NavItemChild

    fun mapQuestCatalog(
        list: List<QuestCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)? = null,
    ): CatalogComponent.Child.NavItemChild

    fun mapToolbarCatalog(
        onClickArrow: () -> Unit
    ): CatalogComponent.ToolbarChild

    fun mapToolbarQuestCatalog(
        onClickArrow: () -> Unit
    ): CatalogComponent.ToolbarChild
}