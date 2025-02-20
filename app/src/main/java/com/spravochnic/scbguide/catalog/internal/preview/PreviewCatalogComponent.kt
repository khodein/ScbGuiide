package com.spravochnic.scbguide.catalog.internal.preview

import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewCatalogComponent
    : CatalogComponent,
    ComponentContext by PreviewComponentContext {

    override val initialState: CatalogComponent.State
        get() = TODO("Not yet implemented")

    override val toolbarStateValue: Value<CatalogComponent.ToolbarChild> = MutableValue(
        CatalogComponent.ToolbarChild(
            toolbarState = ToolbarComponent.State(
                leading = ToolbarComponent.Leading.Arrow(),
                background = Color.Transparent
            ),
            imageRes = R.drawable.art_top_lectory
        )
    )

    override val stateValue: Value<CatalogComponent.State> = MutableValue(
        CatalogComponent.State.Request(RequestComponent.State.Idle)
    )
}