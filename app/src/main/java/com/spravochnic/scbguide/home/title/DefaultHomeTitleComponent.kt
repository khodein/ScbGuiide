package com.spravochnic.scbguide.home.title

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultHomeTitleComponent(
    initialState: HomeTitleComponent.State,
    componentContext: ComponentContext
) : HomeTitleComponent, ComponentContext by componentContext {

    private val _stateValue = MutableValue(initialState)
    override val stateValue: Value<HomeTitleComponent.State> = _stateValue

    override fun update(state: HomeTitleComponent.State) {
        _stateValue.update { state }
    }
}