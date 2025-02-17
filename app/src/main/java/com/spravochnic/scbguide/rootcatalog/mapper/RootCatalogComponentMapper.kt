package com.spravochnic.scbguide.rootcatalog.mapper

import com.spravochnic.scbguide.rootcatalog.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogListModel
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent

interface RootCatalogComponentMapper {
    fun map(
        model: RootCatalogListModel,
        onClick: ((state: NavItemComponent.State) -> Unit),
    ): List<RootCatalogComponent.Child>
}