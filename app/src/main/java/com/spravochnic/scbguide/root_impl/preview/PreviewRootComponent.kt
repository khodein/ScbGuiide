package com.spravochnic.scbguide.root_impl.preview

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.catalog_root_impl.preview.PreviewRootCatalogComponent
import com.spravochnic.scbguide.root_impl.component.RootComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewRootComponent :
    RootComponent,
    ComponentContext by PreviewComponentContext {

    override val stack: Value<ChildStack<*, RootComponent.ChildComponent>> =
        MutableValue(
            ChildStack(
                configuration = Unit,
                instance = RootComponent.ChildComponent.RootCatalogChild(PreviewRootCatalogComponent()),
            )
        )

    override fun pop() = Unit
}