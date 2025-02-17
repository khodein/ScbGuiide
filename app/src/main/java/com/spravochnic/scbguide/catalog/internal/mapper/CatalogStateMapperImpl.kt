package com.spravochnic.scbguide.catalog.internal.mapper

import androidx.compose.ui.graphics.Color
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager

class CatalogStateMapperImpl(
    private val resManager: ResManager,
) : CatalogStateMapper {

    override fun map(): List<CatalogComponent.Child> {
        return emptyList()
    }

    override fun mapToolbarState(onClickArrow: () -> Unit): ToolbarComponent.State {
        return ToolbarComponent.State(
            leading = ToolbarComponent.Leading.Arrow(
                onClick = onClickArrow
            ),
            background = Color.Transparent
        )
    }
}