package com.spravochnic.scbguide.status_impl.module

import com.spravochnic.scbguide.status_api.repository.StatusRepository
import com.spravochnic.scbguide.status_impl.repository.StatusRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val statusModule = module {
    singleOf(::StatusRepositoryImpl) { bind<StatusRepository>() }
}