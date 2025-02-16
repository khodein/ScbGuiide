package com.spravochnic.scbguide.home.navigator

import com.spravochnic.scbguide.root.navigator.RootConfig
import com.spravochnic.scbguide.root.navigator.RootNavigator
import java.lang.ref.WeakReference

class HomeNavigatorImpl : HomeNavigator {

    private var parent: WeakReference<RootNavigator>? = null
    private val navigator: RootNavigator?
        get() = parent?.get()

    override fun init(parent: RootNavigator) {
        this.parent = WeakReference(parent)
    }

    override fun replaceToHome() {
        navigator?.replaceCurrent(RootConfig.Home)
    }

    override fun gotoLectory() {
        navigator?.pushNew(RootConfig.Lectory)
    }

    override fun gotoTest() {
        navigator?.pushNew(RootConfig.Test)
    }
}