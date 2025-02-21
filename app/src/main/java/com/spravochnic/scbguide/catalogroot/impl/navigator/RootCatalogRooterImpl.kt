package com.spravochnic.scbguide.catalogroot.impl.navigator

import com.spravochnic.scbguide.catalogroot.api.router.RootCatalogRooter
import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.config.RootRouter
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