package com.spravochnic.scbguide.rootcatalog.navigator

import com.spravochnic.scbguide.root.navigator.RootConfig
import com.spravochnic.scbguide.root.navigator.RootNavigator
import java.lang.ref.WeakReference

class RootCatalogNavigatorImpl : RootCatalogNavigator {

    private var parent: WeakReference<RootNavigator>? = null
    private val navigator: RootNavigator?
        get() = parent?.get()

    override fun init(parent: RootNavigator) {
        this.parent = WeakReference(parent)
    }

    override fun replaceToRootCatalog() {
        navigator?.replaceCurrent(RootConfig.RootCatalog)
    }
}