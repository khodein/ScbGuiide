package com.spravochnic.scbguide.catalog_root_impl.mapper

import com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent

interface RootCatalogStateMapper {
    fun map(
        model: RootCatalogListModel,
        onClick: ((state: NavItemComponent.State) -> Unit),
    ): List<RootCatalogComponent.Child>
}