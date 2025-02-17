package com.spravochnic.scbguide.root.internal.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.spravochnic.scbguide.catalog.api.navigator.CatalogNavigator
import com.spravochnic.scbguide.root.api.config.RootConfig
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.rootcatalog.api.navigator.RootCatalogNavigator
import java.lang.ref.WeakReference

class RootNavigatorImpl(
    private val rootCatalogNavigator: RootCatalogNavigator,
    private val catalogNavigator: CatalogNavigator,
) : RootNavigator,
    CatalogNavigator by catalogNavigator,
    RootCatalogNavigator by rootCatalogNavigator {

    private var weakReferenceStackNavigation: WeakReference<StackNavigation<RootConfig>>? = null
    private val stackNavigation: StackNavigation<RootConfig>?
        get() = weakReferenceStackNavigation?.get()

    init {
        rootCatalogNavigator.init(this)
        catalogNavigator.init(this)
    }

    override fun init(parent: RootNavigator) {
        rootCatalogNavigator.init(parent)
        catalogNavigator.init(parent)
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