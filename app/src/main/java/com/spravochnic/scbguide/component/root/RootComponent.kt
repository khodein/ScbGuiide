package com.spravochnic.scbguide.component.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.spravochnic.scbguide.component.home.HomeComponent
import com.spravochnic.scbguide.component.splash.SplashComponent

interface RootComponent : BackHandlerOwner {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked()
    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class HomeChild(val component: HomeComponent): Child()
        class SplashChild(val component: SplashComponent): Child()
        class LectoryChild: Child()
        class TestChild: Child()
    }
}