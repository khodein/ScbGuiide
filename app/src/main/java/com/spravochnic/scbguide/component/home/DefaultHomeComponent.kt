package com.spravochnic.scbguide.component.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class DefaultHomeComponent(
    componentContext: ComponentContext,
): HomeComponent, ComponentContext by componentContext {

    private val nav = StackNavigation<Config>()

    private val _stack =
        childStack(
            source = nav,
            serializer = Config.serializer(),
            initialStack = { getInitialStack() },
            childFactory = ::child,
        )

    override val stack: Value<ChildStack<*, HomeComponent.Child>> = _stack

    private fun child(config: Config, componentContext: ComponentContext): HomeComponent.Child {
        return HomeComponent.Child.LectoryChild
    }

    private fun getInitialStack(): List<Config> {
        return listOf(Config.Lectory)
    }

    @Serializable
    private sealed interface Config {
        data object Lectory: Config
    }
}