package com.spravochnic.scbguide.module

import com.spravochnic.scbguide.catalog_root_impl.navigator.RootCatalogRooterImpl
import com.spravochnic.scbguide.catalog_top_impl.router.TopCatalogRouterImpl
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.root_api.router.catalog.RootCatalogRooter
import com.spravochnic.scbguide.root_api.router.topcatalog.TopCatalogRouter
import com.spravochnic.scbguide.root_impl.router.RootRouterImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val routerModule = module {
    singleOf(::RootCatalogRooterImpl) { bind<RootCatalogRooter>() }
    singleOf(::TopCatalogRouterImpl) { bind<TopCatalogRouter>() }
    singleOf(::RootRouterImpl) { bind<RootRouter>() }
}