package com.spravochnic.scbguide.splash.internal.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.splash.api.component.SplashComponent

class DefaultSplashComponent(
    componentContext: ComponentContext,
    private val rootNavigator: RootNavigator,
) : SplashComponent, ComponentContext by componentContext {

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

    override fun onFinish() {
        rootNavigator.replaceToRootCatalog()
    }
}