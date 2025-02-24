package com.spravochnic.scbguide.splash_impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.splash_api.component.SplashComponent
import com.spravochnic.scbguide.uikit.R
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DefaultSplashComponent(
    componentContext: ComponentContext,
) : SplashComponent, ComponentContext by componentContext, KoinComponent {

    private val router by inject<RootRouter>()

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
        router.replaceToRootCatalog()
    }
}