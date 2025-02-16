package com.spravochnic.scbguide.uikit.navitem.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultNavItemComponent(
    initialState: NavItemComponent.State,
    componentContext: ComponentContext,
) : NavItemComponent, ComponentContext by componentContext {

    private val _stateValue = MutableValue(initialState)
    override val stateValue: Value<NavItemComponent.State> = _stateValue

    override fun update(state: NavItemComponent.State) {
        _stateValue.update { state }
    }
}