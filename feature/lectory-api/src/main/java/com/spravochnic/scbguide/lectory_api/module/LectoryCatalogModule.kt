package com.spravochnic.scbguide.lectory_api.module

import com.spravochnic.scbguide.lectory_api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.root_api.module.RootModule

interface LectoryCatalogModule : RootModule {
    fun getLectoryCatalogRepository(): LectoryCatalogRepository
}