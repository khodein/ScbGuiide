package com.spravochnic.scbguide.catalog.internal.mapper

import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent

interface CatalogStateMapper {
    fun map(): List<CatalogComponent.Child>
    fun mapToolbarState(
        onClickArrow: () -> Unit
    ): ToolbarComponent.State
}