package com.spravochnic.scbguide.catalog

import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewCatalogComponent
    : CatalogComponent,
    ComponentContext by PreviewComponentContext {

    override val toolbarStateValue: Value<ToolbarComponent.State> = MutableValue(
        ToolbarComponent.State(
            leading = ToolbarComponent.Leading.Arrow(),
            background = Color.Transparent
        )
    )

    override val stateValue: Value<CatalogComponent.State> = MutableValue(
        CatalogComponent.State.Request(RequestComponent.State.Idle)
    )
}