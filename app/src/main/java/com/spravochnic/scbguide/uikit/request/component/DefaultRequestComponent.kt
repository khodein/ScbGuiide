package com.spravochnic.scbguide.uikit.request.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.spravochnic.scbguide.uikit.button.component.ButtonItemComponent
import com.spravochnic.scbguide.uikit.button.component.DefaultButtonItemComponent
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.uikit.theme.color.TextPrimaryInverse

class DefaultRequestComponent(
    initialState: RequestComponent.State = RequestComponent.State.Idle,
    private val componentContext: ComponentContext,
) : RequestComponent, ComponentContext by componentContext {

    private val _stateValue: MutableValue<RequestComponent.State> = MutableValue(initialState)
    override val stateValue: Value<RequestComponent.State> = _stateValue

    private val _buttonReloadValue: MutableValue<ButtonItemComponent> = MutableValue(
        DefaultButtonItemComponent(
            initialState = getDefaultReloadButtonItem(
                text = "",
                onClick = null
            ),
            componentContext = componentContext
        )
    )
    override val buttonReloadValue: Value<ButtonItemComponent> = _buttonReloadValue

    init {
        setButtonReloadComponent(initialState)
    }

    override fun update(state: RequestComponent.State) {
        setButtonReloadComponent(state)
        _stateValue.update { state }
    }

    private fun setButtonReloadComponent(
        state: RequestComponent.State,
    ) {
        if (state is RequestComponent.State.Error) {
            _buttonReloadValue.value.update(
                getDefaultReloadButtonItem(
                    text = state.buttonReloadMessage.orEmpty(),
                    onClick = state.onReloadClick
                )
            )
        }
    }

    private companion object {
        fun getDefaultReloadButtonItem(
            text: String,
            onClick: (() -> Unit)? = null
        ): ButtonItemComponent.State {
            return ButtonItemComponent.State(
                id = "request_reload_button_item",
                fill = ButtonItemComponent.Fill.Custom(
                    background = Note,
                    textColor = TextPrimaryInverse,
                ),
                text = text,
                onClick = onClick,
            )
        }
    }
}