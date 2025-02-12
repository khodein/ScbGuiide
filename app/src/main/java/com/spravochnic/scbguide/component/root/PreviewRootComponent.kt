package com.spravochnic.scbguide.component.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.preview.PreviewComponentContext
import com.spravochnic.scbguide.component.home.PreviewHomeComponent

class PreviewRootComponent :
    RootComponent,
    ComponentContext by PreviewComponentContext {

    override val stack: Value<ChildStack<*, RootComponent.Child>> =
        MutableValue(
            ChildStack(
                configuration = Unit,
                instance = RootComponent.Child.HomeChild(PreviewHomeComponent()),
            )
        )

    override fun onBackClicked() = Unit
    override fun onBackClicked(toIndex: Int) = Unit
}