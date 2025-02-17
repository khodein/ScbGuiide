package com.spravochnic.scbguide.rootcatalog.internal.mapper

import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogListModel
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent

interface RootCatalogStateMapper {
    fun map(
        model: RootCatalogListModel,
        onClick: ((state: NavItemComponent.State) -> Unit),
    ): List<RootCatalogComponent.Child>
}