package com.spravochnic.scbguide.uikit.button.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultButtonItemComponent(
    initialState: ButtonItemComponent.State,
    componentContext: ComponentContext,
) : ButtonItemComponent, ComponentContext by componentContext {

    private val _stateValue = MutableValue(initialState)
    override val stateValue: Value<ButtonItemComponent.State> = _stateValue

    override fun update(state: ButtonItemComponent.State) {
        _stateValue.update { state }
    }
}