package com.spravochnic.scbguide.component.home

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface HomeComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        data object LectoryChild: Child()
    }
}