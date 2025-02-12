package com.spravochnic.scbguide.component.splash

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

class DefaultSplashComponent(
    componentContext: ComponentContext,
) : SplashComponent, ComponentContext by componentContext {

    override val stack: Value<ChildStack<*, SplashComponent>>
        get() = TODO("Not yet implemented")


}