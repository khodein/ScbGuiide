package com.spravochnic.scbguide.uikit.navitem.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.preview.PreviewComponentContext
import com.spravochnic.scbguide.ui.color.Note

class PreviewNavItemComponent
    : NavItemComponent,
    ComponentContext by PreviewComponentContext {

    private val _stateValue = MutableValue(
        NavItemComponent.State(
            id = "",
            text = "Лекторий",
            subText = "3 уровня",
            leading = NavItemComponent.State.Leading(
                res = R.drawable.ic_splash,
                tint = Note
            ),
            trailing = NavItemComponent.State.Trailing.Arrow()
        )
    )
    override val stateValue: Value<NavItemComponent.State> = _stateValue

    override fun onClickNavItem() = Unit

    override fun update(state: NavItemComponent.State) = Unit
}