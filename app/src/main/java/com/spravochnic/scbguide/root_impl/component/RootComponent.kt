package com.spravochnic.scbguide.root_impl.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.spravochnic.scbguide.main.module.ChildComponent

interface RootComponent : BackHandlerOwner {

    val stack: Value<ChildStack<*, ChildComponent>>

    fun pop()
}