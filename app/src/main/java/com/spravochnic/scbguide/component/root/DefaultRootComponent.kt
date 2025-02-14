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
import com.spravochnic.scbguide.component.home.HomeComponent
import com.spravochnic.scbguide.component.splash.DefaultSplashComponent
import com.spravochnic.scbguide.component.splash.SplashComponent
import com.spravochnic.scbguide.navigate.HomeProvider
import com.spravochnic.scbguide.navigate.NavProvider
import com.spravochnic.scbguide.navigate.SplashProvider
import com.spravochnic.scbguide.utils.ResManager
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
    private val resManager: ResManager,
) : RootComponent, ComponentContext by componentContext,
    HomeProvider,
    SplashProvider {

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
                DefaultHomeComponent(
                    componentContext = componentContext,
                    resManager = resManager,
                    provider = this
                )
            )

            is Config.Splash -> RootComponent.Child.SplashChild(
                DefaultSplashComponent(
                    componentContext = componentContext,
                    provider = this
                )
            )

            is Config.Lectory -> RootComponent.Child.LectoryChild()

            is Config.Test -> RootComponent.Child.TestChild()
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

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Test: Config

        @Serializable
        data object Lectory: Config

        @Serializable
        data object Home : Config

        @Serializable
        data object Splash: Config
    }

    override fun gotoLectory() {
        nav.pushNew(Config.Lectory)
    }

    override fun gotoTest() {
        nav.pushNew(Config.Test)
    }

    override fun finishSplash() {
        onBackClicked()
    }
}