package com.spravochnic.scbguide.rootcatalog.mapper

import com.spravochnic.scbguide.rootcatalog.model.RootCatalogModel
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent

interface RootCatalogComponentMapper {
    fun map(
        list: List<RootCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit),
    ): List<NavItemComponent.State>
}