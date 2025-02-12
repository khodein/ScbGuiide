package com.spravochnic.scbguide.component.splash

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface SplashComponent {

    val stack: Value<ChildStack<*, SplashComponent>>
}