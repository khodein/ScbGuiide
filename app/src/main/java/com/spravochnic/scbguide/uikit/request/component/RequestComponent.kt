package com.spravochnic.scbguide.uikit.request.component

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.uikit.button.component.ButtonItemComponent
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.uikit.theme.color.Secondary

interface RequestComponent {

    val stateValue: Value<State>

    val buttonReloadValue: Value<ButtonItemComponent>

    fun update(state: State)

    sealed class State {
        data object Idle : State()

        data object Success : State()

        data class Loading(
            val trackColor: Color = Secondary,
            val strokeWidth: Dp = 4.dp,
        ) : State()

        data class Error(
            val errorImageSize: Dp = 70.dp,
            @DrawableRes val errorRes: Int = R.drawable.ic_error,
            val messageColor: Color = Note,
            val message: String,
            val buttonReloadMessage: String? = null,
            val onReloadClick: (() -> Unit)? = null
        ) : State()
    }
}