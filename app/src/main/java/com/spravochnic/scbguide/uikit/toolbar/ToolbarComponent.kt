package com.spravochnic.scbguide.uikit.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.uikit.theme.color.Secondary

interface ToolbarComponent {

    data class State(
        val title: Title? = null,
        val background: Color,
        val leading: Leading? = null,
    )

    data class Title(
        val text: String,
        val textColor: Color
    )

    sealed class Leading(
        @get:DrawableRes open val res: Int,
        open val tint: Color,
    ) {
        data class Arrow(
            override val res: Int = R.drawable.ic_left_arrow,
            override val tint: Color = Secondary,
            val onClick: (() -> Unit)? = null
        ) : Leading(
            res = res,
            tint = tint
        )
    }
}