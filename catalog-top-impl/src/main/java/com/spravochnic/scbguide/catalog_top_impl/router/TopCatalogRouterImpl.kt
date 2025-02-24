package com.spravochnic.scbguide.catalog_top_impl.router

import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.root_api.router.topcatalog.TopCatalogRouter
import java.lang.ref.WeakReference

class TopCatalogRouterImpl : TopCatalogRouter {

    private var parent: WeakReference<RootRouter>? = null
    private val navigator: RootRouter?
        get() = parent?.get()

    override fun init(parent: RootRouter) {
        this.parent = WeakReference(parent)
    }

    override fun gotoTopCatalog(alias: String) {
        navigator?.pushNew(RootConfig.TopCatalog(alias))
    }
}