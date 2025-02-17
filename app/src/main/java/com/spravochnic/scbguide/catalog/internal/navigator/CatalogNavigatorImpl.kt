package com.spravochnic.scbguide.catalog.internal.navigator

import com.spravochnic.scbguide.catalog.api.navigator.CatalogNavigator
import com.spravochnic.scbguide.root.api.config.RootConfig
import com.spravochnic.scbguide.root.api.config.RootNavigator
import java.lang.ref.WeakReference

class CatalogNavigatorImpl : CatalogNavigator {

    private var parent: WeakReference<RootNavigator>? = null
    private val navigator: RootNavigator?
        get() = parent?.get()

    override fun init(parent: RootNavigator) {
        this.parent = WeakReference(parent)
    }

    override fun gotoCatalog(alias: String) {
        navigator?.pushNew(RootConfig.Catalog(alias))
    }
}