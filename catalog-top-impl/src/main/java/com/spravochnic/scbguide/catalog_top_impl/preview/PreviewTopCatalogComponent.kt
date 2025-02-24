package com.spravochnic.scbguide.catalog_top_impl.preview

import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.catalog_top_api.component.TopCatalogComponent
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewTopCatalogComponent
    : TopCatalogComponent,
    ComponentContext by PreviewComponentContext {

    override val initialState: TopCatalogComponent.State
        get() = TODO("Not yet implemented")

    override val toolbarStateValue: Value<TopCatalogComponent.ToolbarChild> = MutableValue(
        TopCatalogComponent.ToolbarChild(
            toolbarState = com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent.State(
                leading = com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent.Leading.Arrow(),
                background = Color.Transparent
            ),
            imageRes = R.drawable.art_top_lectory
        )
    )

    override val stateValue: Value<TopCatalogComponent.State> = MutableValue(
        TopCatalogComponent.State.Request(com.spravochnic.scbguide.uikit.request.RequestComponent.State.Idle)
    )
}