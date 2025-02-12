package com.spravochnic.scbguide.uikit.navitem.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultNavItemComponent(
    private val provider: NavItemComponent.Provider,
    componentContext: ComponentContext,
) : NavItemComponent, ComponentContext by componentContext {

    private val _stateValue = MutableValue(
        NavItemComponent.State(
            id = "",
            text = ""
        )
    )
    override val stateValue: Value<NavItemComponent.State> = _stateValue

    override fun update(state: NavItemComponent.State) {
        _stateValue.update { state }
    }

    override fun onClickNavItem() {
        provider.onClick(state = stateValue.value)
    }
}