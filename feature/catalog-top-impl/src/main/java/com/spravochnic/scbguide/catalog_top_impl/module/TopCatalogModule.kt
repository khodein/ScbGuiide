package com.spravochnic.scbguide.catalog_top_impl.module

import com.spravochnic.scbguide.catalog_top_api.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.catalog_top_impl.mapper.TopCatalogStateMapperImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val topCatalogModule = module {
    singleOf(::TopCatalogStateMapperImpl) { bind<TopCatalogStateMapper>() }
}