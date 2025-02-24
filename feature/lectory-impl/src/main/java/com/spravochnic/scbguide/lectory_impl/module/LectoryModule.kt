package com.spravochnic.scbguide.lectory_impl.module

import com.spravochnic.scbguide.lectory_api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.lectory_impl.repository.LectoryCatalogRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val lectoryModule = module {
    singleOf(::LectoryCatalogRepositoryImpl) { bind<LectoryCatalogRepository>() }
}