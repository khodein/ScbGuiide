package com.spravochnic.scbguide.component.splash

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.arkivanov.decompose.value.Value

interface SplashComponent {
    val state: Value<State>

    fun onFinish()

    data class State(
        @StringRes val footerTextRes: Int,
        @StringRes val centerTextRes: Int,
        @DrawableRes val imageCenterRes: Int,
        @DrawableRes val backgroundRes: Int,
        val duration: Long,
    )
}