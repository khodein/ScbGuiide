package com.spravochnic.scbguide.splash.impl.module

import com.spravochnic.scbguide.root_api.module.RootModule
import com.spravochnic.scbguide.splash.api.module.SplashModule

class SplashModuleImpl(
    private val rootModule: RootModule,
) : SplashModule, RootModule by rootModule {
}