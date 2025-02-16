package com.spravochnic.scbguide.root.navigator.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.root.navigator.RootConfig

interface RootComponentFactory {
    fun get(
        config: RootConfig,
        componentContext: ComponentContext,
    ): ChildComponent
}