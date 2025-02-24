package com.spravochnic.scbguide.uikit.button

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.uikit.theme.color.Primary
import com.spravochnic.scbguide.uikit.theme.color.Secondary
import com.spravochnic.scbguide.uikit.theme.color.TextPrimaryInverse

interface ButtonItemComponent {

    data class State(
        val id: String,
        val text: String,
        val fill: Fill,
        val onClick: (() -> Unit)? = null,
    )

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