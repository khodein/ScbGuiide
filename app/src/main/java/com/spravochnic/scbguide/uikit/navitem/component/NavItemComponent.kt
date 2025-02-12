package com.spravochnic.scbguide.uikit.navitem.component

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.ui.color.Note

interface NavItemComponent {

    val stateValue: Value<State>

    fun onClickNavItem()

    fun update(state: State)

    data class State(
        val id: String,
        val text: String,
        val subText: String? = null,
        val leading: Leading? = null,
        val trailing: Trailing? = null,
    ) {
        data class Leading(
            @DrawableRes val res: Int,
            val tint: Color,
        )
        sealed interface Trailing {
           data class Arrow(
               @DrawableRes val res: Int = R.drawable.ic_arrow_mini_right,
               val tint: Color = Note
           ): Trailing
        }
    }

    interface Provider {
        fun onClick(state: State)
    }
}