package com.spravochnic.scbguide.root_api.module

import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.root_api.utils.ResManager

interface RootModule {
    fun getResManager(): ResManager
    fun getRouter(): RootRouter
}