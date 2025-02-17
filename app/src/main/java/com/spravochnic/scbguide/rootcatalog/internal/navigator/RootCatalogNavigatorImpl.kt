package com.spravochnic.scbguide.rootcatalog.internal.navigator

import com.spravochnic.scbguide.root.api.config.RootConfig
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.rootcatalog.api.navigator.RootCatalogNavigator
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