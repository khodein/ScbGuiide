package com.spravochnic.scbguide.splash.internal.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.splash.api.component.SplashComponent
import com.spravochnic.scbguide.splash.api.factory.SplashFactory
import com.spravochnic.scbguide.splash.internal.component.DefaultSplashComponent

class SplashFactoryImpl(
    private val rootNavigator: RootNavigator
) : SplashFactory {

    override fun get(componentContext: ComponentContext): SplashComponent {
        return DefaultSplashComponent(
            componentContext = componentContext,
            rootNavigator = rootNavigator,
        )
    }
}