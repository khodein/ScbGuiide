package com.spravochnic.scbguide.lectory.api.module

import com.spravochnic.scbguide.lectory.api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.root_api.module.RootModule

interface LectoryCatalogModule : RootModule {
    fun getLectoryCatalogRepository(): LectoryCatalogRepository
}