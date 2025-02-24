package com.spravochnic.scbguide.splash_impl.module

import com.spravochnic.scbguide.root_api.module.RootModule
import com.spravochnic.scbguide.splash_api.module.SplashModule

class SplashModuleImpl(
    private val rootModule: RootModule,
) : SplashModule, RootModule by rootModule