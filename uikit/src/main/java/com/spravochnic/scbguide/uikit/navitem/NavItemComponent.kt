package com.spravochnic.scbguide.uikit.navitem

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.spravochnic.scbguide.uikit.R
import com.spravochnic.scbguide.uikit.theme.color.Note

interface NavItemComponent {

    data class State(
        val id: String,
        val text: String,
        val data: Any? = null,
        val subText: String? = null,
        val leading: Leading? = null,
        val trailing: Trailing? = null,
        val onClick: ((state: State) -> Unit)? = null
    ) {
        data class Leading(
            @DrawableRes val res: Int,
            val tint: Color? = null,
        )

        sealed interface Trailing {
           data class Arrow(
               @DrawableRes val res: Int = R.drawable.ic_arrow_mini_right,
               val tint: Color = Note
           ): Trailing
        }
    }
}