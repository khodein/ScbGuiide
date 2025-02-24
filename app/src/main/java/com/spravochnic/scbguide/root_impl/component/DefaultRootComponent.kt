package com.spravochnic.scbguide.root_impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.main.module.ChildComponent
import com.spravochnic.scbguide.main.module.MainModule
import com.spravochnic.scbguide.root_api.config.RootConfig

class DefaultRootComponent(
    componentContext: ComponentContext,
    private val mainModule: MainModule,
) : RootComponent, ComponentContext by componentContext {

    private val stackNavigator = StackNavigation<RootConfig>()

    init {
        mainModule.rootRouter.init(stackNavigator)
    }

    private val _stack =
        childStack(
            source = stackNavigator,
            serializer = RootConfig.serializer(),
            initialStack = ::getInitialStack,
            childFactory = mainModule::get,
        )

    override val stack: Value<ChildStack<*, ChildComponent>> = _stack

    override fun pop() {
        mainModule.rootRouter.pop()
    }

    private fun getInitialStack(): List<RootConfig> {
        return listOf(RootConfig.Splash)
    }
}