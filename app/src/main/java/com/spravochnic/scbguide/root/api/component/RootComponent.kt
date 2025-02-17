package com.spravochnic.scbguide.root.api.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.spravochnic.scbguide.root.internal.navigator.factory.ChildComponent

interface RootComponent : BackHandlerOwner {

    val stack: Value<ChildStack<*, ChildComponent>>

    fun pop()
}