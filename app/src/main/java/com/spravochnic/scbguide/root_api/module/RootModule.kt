package com.spravochnic.scbguide.root_api.module

import com.spravochnic.scbguide.root_api.config.RootRouter
import com.spravochnic.scbguide.utils.resmanager.ResManager

interface RootModule {
    fun getResManager(): ResManager
    fun getRouter(): RootRouter
}