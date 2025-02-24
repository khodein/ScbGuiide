package com.spravochnic.scbguide.uikit.request

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.uikit.R
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.uikit.theme.color.Secondary
import kotlinx.serialization.Serializable

interface RequestComponent {

    @Serializable
    sealed class State {
        data object Idle : State()

        data object Success : State()

        data class Loading(
            val trackColor: Color = Secondary,
            val strokeWidth: Dp = 4.dp,
        ) : State()

        data class Error(
            val errorImageSize: Dp = 150.dp,
            @DrawableRes val errorRes: Int = R.drawable.art_error,
            val messageColor: Color = Note,
            val message: String,
            val buttonReloadMessage: String? = null,
            val onReloadClick: (() -> Unit)? = null
        ) : State()

        data class Empty(
            val emptyImageSize: Dp = 150.dp,
            val messageColor: Color = Secondary,
            val message: String,
            val buttonReloadMessage: String? = null,
            @DrawableRes val emptyRes: Int = R.drawable.art_empty,
            val onReloadClick: (() -> Unit)? = null
        ) : State()
    }
}