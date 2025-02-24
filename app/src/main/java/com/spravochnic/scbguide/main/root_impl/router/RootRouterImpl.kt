package com.spravochnic.scbguide.main.root_impl.router

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.root_api.router.catalog.RootCatalogRooter
import com.spravochnic.scbguide.root_api.router.topcatalog.TopCatalogRouter
import java.lang.ref.WeakReference

class RootRouterImpl(
    private val rootCatalogRooter: RootCatalogRooter,
    private val topCatalogRouter: TopCatalogRouter,
) : RootRouter,
    TopCatalogRouter by topCatalogRouter,
    RootCatalogRooter by rootCatalogRooter {

    private var weakReferenceStackNavigation: WeakReference<StackNavigation<RootConfig>>? = null
    private val stackNavigation: StackNavigation<RootConfig>?
        get() = weakReferenceStackNavigation?.get()

    init {
        rootCatalogRooter.init(this)
        topCatalogRouter.init(this)
    }

    override fun init(parent: RootRouter) {
        rootCatalogRooter.init(parent)
        topCatalogRouter.init(parent)
    }

    override fun init(parent: StackNavigation<RootConfig>) {
        this.weakReferenceStackNavigation = WeakReference(parent)
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