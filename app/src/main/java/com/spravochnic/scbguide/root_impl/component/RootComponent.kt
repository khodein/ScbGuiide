package com.spravochnic.scbguide.root_impl.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalog_top_api.component.TopCatalogComponent
import com.spravochnic.scbguide.splash_api.component.SplashComponent

interface RootComponent : BackHandlerOwner {

    val stack: Value<ChildStack<*, ChildComponent>>

    fun pop()

    sealed class ChildComponent {
        class RootCatalogChild(val component: RootCatalogComponent) : ChildComponent()
        class SplashChild(val component: SplashComponent) : ChildComponent()
        class TopCatalogChild(val component: TopCatalogComponent) : ChildComponent()
    }
}