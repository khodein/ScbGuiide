package com.spravochnic.scbguide.component.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.component.home.DefaultHomeComponent
import com.spravochnic.scbguide.component.splash.DefaultSplashComponent
import com.spravochnic.scbguide.component.splash.SplashComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext, SplashComponent.Provider {

    private val nav = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = nav,
            serializer = Config.serializer(),
            initialStack = { getInitialStack() },
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, RootComponent.Child>> = _stack

    init {
        nav.pushNew(Config.Splash)
    }

    private fun child(config: Config, componentContext: ComponentContext): RootComponent.Child {
        return when(config) {
            is Config.Home -> RootComponent.Child.HomeChild(
                DefaultHomeComponent(componentContext = componentContext)
            )

            is Config.Splash -> RootComponent.Child.SplashChild(
                DefaultSplashComponent(
                    componentContext = componentContext,
                    provider = this
                )
            )
        }
    }

    override fun onBackClicked() {
        nav.pop()
    }

    override fun onBackClicked(toIndex: Int) {
        nav.popTo(index = toIndex)
    }

    private fun getInitialStack(): List<Config> {
        return listOf(Config.Home)
    }

    override fun onSplashFinish() {
        onBackClicked()
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Home : Config

        @Serializable
        data object Splash: Config
    }
}