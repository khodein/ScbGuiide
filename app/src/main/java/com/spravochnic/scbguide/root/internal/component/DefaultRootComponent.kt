package com.spravochnic.scbguide.root.internal.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.root.api.component.RootComponent
import com.spravochnic.scbguide.root.api.config.RootConfig
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.root.internal.builder.ChildComponent
import com.spravochnic.scbguide.root.internal.builder.RootComponentBuilder

class DefaultRootComponent(
    private val rootNavigator: RootNavigator,
    componentContext: ComponentContext,
    rootComponentBuilder: RootComponentBuilder,
) : RootComponent, ComponentContext by componentContext {

    private val stackNavigator = StackNavigation<RootConfig>()

    init {
        rootNavigator.init(stackNavigator)
    }

    private val _stack =
        childStack(
            source = stackNavigator,
            serializer = RootConfig.serializer(),
            initialStack = ::getInitialStack,
            childFactory = rootComponentBuilder::get,
        )

    override val stack: Value<ChildStack<*, ChildComponent>> = _stack

    override fun pop() {
        rootNavigator.pop()
    }

    private fun getInitialStack(): List<RootConfig> {
        return listOf(RootConfig.Splash)
    }
}