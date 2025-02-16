package com.spravochnic.scbguide.uikit.request.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.uikit.button.component.ButtonItemComponent
import com.spravochnic.scbguide.uikit.button.component.PreviewButtonItemComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewRequestComponent :
    RequestComponent,
    ComponentContext by PreviewComponentContext {

    override val stateValue: Value<RequestComponent.State> = MutableValue(
        RequestComponent.State.Error(
            message = "Error",
        )
    )
    override val buttonReloadValue: Value<ButtonItemComponent> = MutableValue(
        PreviewButtonItemComponent()
    )

    override fun update(state: RequestComponent.State) = Unit
}