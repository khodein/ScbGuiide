package com.spravochnic.scbguide.main.root_impl.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.spravochnic.scbguide.main.root_impl.module.ChildComponent

interface RootComponent : BackHandlerOwner {

    val stack: Value<ChildStack<*, ChildComponent>>

    fun pop()
}