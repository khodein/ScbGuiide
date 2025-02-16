package com.spravochnic.scbguide.splash

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewSplashComponent :
    SplashComponent,
    ComponentContext by PreviewComponentContext {

    private val _state = MutableValue(
        SplashComponent.State(
            footerTextRes = R.string.default_splash_footer_text,
            centerTextRes = R.string.default_splash_center_text,
            imageCenterRes = R.drawable.ic_splash,
            backgroundRes = R.drawable.background_splash,
            duration = 1000L
        )
    )
    override val state: Value<SplashComponent.State> = _state

    override fun onFinish() = Unit
}