package com.spravochnic.scbguide.uikit.button.component

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.uikit.theme.color.Primary
import com.spravochnic.scbguide.uikit.theme.color.Secondary
import com.spravochnic.scbguide.uikit.theme.color.TextPrimaryInverse

interface ButtonItemComponent {

    val stateValue: Value<State>

    data class State(
        val id: String,
        val text: String,
        val fill: Fill,
        val onClick: (() -> Unit)? = null,
    )

    fun update(state: State)

    sealed class Fill(
        open val background: Color,
        open val textColor: Color,
    ) {
        data class Filled(
            override val background: Color = Secondary,
            override val textColor: Color = TextPrimaryInverse,
        ) : Fill(
            background = background,
            textColor = textColor
        )

        data class Outline(
            override val background: Color = Primary,
            override val textColor: Color = Secondary,
            val strokeColor: Color = Secondary,
            val strokeWidth: Dp = 1.5f.dp
        ) : Fill(
            background = background,
            textColor = textColor
        )

        data class Custom(
            override val background: Color = Primary,
            override val textColor: Color = Secondary,
        ) : Fill(
            background = background,
            textColor = textColor
        )
    }
}