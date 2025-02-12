package com.spravochnic.scbguide.component.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.preview.PreviewComponentContext

class PreviewHomeComponent :
    HomeComponent,
    ComponentContext by PreviewComponentContext  {
    override val stack: Value<ChildStack<*, HomeComponent.Child>> = MutableValue(
        ChildStack(
            configuration = Unit,
            instance = HomeComponent.Child.LectoryChild,
        )
    )
}