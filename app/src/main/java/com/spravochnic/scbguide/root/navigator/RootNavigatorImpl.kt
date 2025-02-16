package com.spravochnic.scbguide.root.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.spravochnic.scbguide.home.navigator.HomeNavigator
import java.lang.ref.WeakReference

class RootNavigatorImpl(
    homeNavigator: HomeNavigator,
) : RootNavigator,
    HomeNavigator by homeNavigator {

    private var weakReferenceStackNavigation: WeakReference<StackNavigation<RootConfig>>? = null
    private val stackNavigation: StackNavigation<RootConfig>?
        get() = weakReferenceStackNavigation?.get()

    init {
        homeNavigator.init(this)
    }

    override fun init(stackNavigation: StackNavigation<RootConfig>) {
        this.weakReferenceStackNavigation = WeakReference(stackNavigation)
    }

    override fun pushNew(config: RootConfig) {
        stackNavigation?.pushNew(config)
    }

    override fun replaceCurrent(config: RootConfig) {
        stackNavigation?.replaceCurrent(config)
    }

    override fun pop() {
        stackNavigation?.pop()
    }

    override fun pop(toIndex: Int) {
        stackNavigation?.popTo(index = toIndex)
    }
}