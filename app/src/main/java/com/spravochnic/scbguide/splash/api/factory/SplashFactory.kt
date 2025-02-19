package com.spravochnic.scbguide.splash.api.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.splash.api.component.SplashComponent

interface SplashFactory {
    fun get(componentContext: ComponentContext): SplashComponent
}