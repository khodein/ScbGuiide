package com.spravochnic.scbguide.root.navigator.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.home.DefaultHomeComponent
import com.spravochnic.scbguide.root.navigator.RootConfig
import com.spravochnic.scbguide.root.navigator.RootNavigator
import com.spravochnic.scbguide.splash.DefaultSplashComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager

class RootComponentFactoryImpl(
    private val rootNavigator: RootNavigator,
    private val resManager: ResManager,
) : RootComponentFactory {

    override fun get(
        config: RootConfig,
        componentContext: ComponentContext,
    ): ChildComponent {
        return when (config) {
            is RootConfig.Home -> ChildComponent.HomeChild(
                DefaultHomeComponent(
                    componentContext = componentContext,
                    resManager = resManager,
                    homeNavigator = rootNavigator
                )
            )

            is RootConfig.Splash -> ChildComponent.SplashChild(
                DefaultSplashComponent(
                    componentContext = componentContext,
                    rootNavigator = rootNavigator,
                )
            )

            is RootConfig.Lectory -> ChildComponent.LectoryChild()

            is RootConfig.Test -> ChildComponent.TestChild()
        }
    }
}