package com.spravochnic.scbguide.preview

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

internal object PreviewComponentContext : ComponentContext by DefaultComponentContext(
    lifecycle = LifecycleRegistry(),
)