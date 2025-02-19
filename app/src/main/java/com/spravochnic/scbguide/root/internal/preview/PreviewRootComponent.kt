package com.spravochnic.scbguide.root.internal.preview

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.root.api.component.RootComponent
import com.spravochnic.scbguide.root.internal.builder.ChildComponent
import com.spravochnic.scbguide.rootcatalog.internal.preview.PreviewRootCatalogComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewRootComponent :
    RootComponent,
    ComponentContext by PreviewComponentContext {

    override val stack: Value<ChildStack<*, ChildComponent>> =
        MutableValue(
            ChildStack(
                configuration = Unit,
                instance = ChildComponent.RootCatalogChild(PreviewRootCatalogComponent()),
            )
        )

    override fun pop() = Unit
}