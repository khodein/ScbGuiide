package com.spravochnic.scbguide.catalogroot.impl.navigator

import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.root_api.router.catalog.RootCatalogRooter
import java.lang.ref.WeakReference

class RootCatalogRooterImpl : RootCatalogRooter {

    private var parent: WeakReference<RootRouter>? = null
    private val navigator: RootRouter?
        get() = parent?.get()

    override fun init(parent: RootRouter) {
        this.parent = WeakReference(parent)
    }

    override fun replaceToRootCatalog() {
        navigator?.replaceCurrent(RootConfig.RootCatalog)
    }
}