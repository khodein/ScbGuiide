package com.spravochnic.scbguide.root.navigator.factory

import com.spravochnic.scbguide.home.HomeComponent
import com.spravochnic.scbguide.splash.SplashComponent

sealed class ChildComponent {
    class HomeChild(val component: HomeComponent) : ChildComponent()
    class SplashChild(val component: SplashComponent) : ChildComponent()
    class LectoryChild : ChildComponent()
    class TestChild : ChildComponent()
}