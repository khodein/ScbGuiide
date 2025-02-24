package com.spravochnic.scbguide.module

import com.spravochnic.scbguide.root_api.utils.ResManager
import com.spravochnic.scbguide.root_impl.utils.resmanager.ResManagerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::ResManagerImpl) { bind<ResManager>() }
}