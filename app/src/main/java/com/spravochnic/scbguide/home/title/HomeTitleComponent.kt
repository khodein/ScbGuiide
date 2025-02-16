package com.spravochnic.scbguide.home.title

import androidx.annotation.DrawableRes
import com.arkivanov.decompose.value.Value

interface HomeTitleComponent {
    val stateValue: Value<State>

    fun update(state: State)

    data class State(
        val title: String,
        val subTitle: SubTitle? = null,
    ) {
        data class SubTitle(
            val text: String,
            @DrawableRes val leadingRes: Int,
        )
    }
}