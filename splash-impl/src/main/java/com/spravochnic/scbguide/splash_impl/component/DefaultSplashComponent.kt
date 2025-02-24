package com.spravochnic.scbguide.splash_impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.splash_api.component.SplashComponent
import com.spravochnic.scbguide.splash_api.module.SplashModule
import com.spravochnic.scbguide.splash_impl.R

class DefaultSplashComponent(
    componentContext: ComponentContext,
    private val splashModule: SplashModule,
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
        splashModule.getRouter().replaceToRootCatalog()
    }
}