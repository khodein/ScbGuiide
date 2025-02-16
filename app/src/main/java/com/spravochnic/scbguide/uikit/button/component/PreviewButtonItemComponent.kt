package com.spravochnic.scbguide.uikit.button.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewButtonItemComponent :
    ButtonItemComponent,
    ComponentContext by PreviewComponentContext {

    override val stateValue: Value<ButtonItemComponent.State> = MutableValue(
        ButtonItemComponent.State(
            id = "",
            text = "Text",
            fill = ButtonItemComponent.Fill.Outline(),
            onClick = {}
        )
    )

    override fun update(state: ButtonItemComponent.State) = Unit
}