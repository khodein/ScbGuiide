package com.spravochnic.scbguide.main.root_impl.module

import com.spravochnic.scbguide.root_api.config.RootRouter
import com.spravochnic.scbguide.root_api.module.RootModule
import com.spravochnic.scbguide.utils.resmanager.ResManager

class RootModuleImpl(
    private val resManager: ResManager,
    private val rootRouter: RootRouter,
) : RootModule {

    override fun getResManager(): ResManager {
        return resManager
    }

    override fun getRouter(): RootRouter {
        return rootRouter
    }
}