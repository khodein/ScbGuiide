package com.spravochnic.scbguide.catalogroot.impl.mapper

import com.spravochnic.scbguide.catalogroot.api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogListModel
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent

interface RootCatalogStateMapper {
    fun map(
        model: RootCatalogListModel,
        onClick: ((state: NavItemComponent.State) -> Unit),
    ): List<RootCatalogComponent.Child>
}