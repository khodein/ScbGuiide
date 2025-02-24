package com.spravochnic.scbguide.catalog_root_impl.module

import com.spravochnic.scbguide.catalog_root_api.mapper.RootCatalogStateMapper
import com.spravochnic.scbguide.catalog_root_api.repository.RootCatalogRepository
import com.spravochnic.scbguide.catalog_root_impl.mapper.RootCatalogStateMapperImpl
import com.spravochnic.scbguide.catalog_root_impl.repository.RootCatalogRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rootCatalogModule = module {
    singleOf(::RootCatalogRepositoryImpl) { bind<RootCatalogRepository>() }
    singleOf(::RootCatalogStateMapperImpl) { bind<RootCatalogStateMapper>() }
}