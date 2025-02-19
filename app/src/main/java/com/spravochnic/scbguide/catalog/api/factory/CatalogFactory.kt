package com.spravochnic.scbguide.catalog.api.factory

import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent

interface CatalogFactory {
    fun get(
        componentContext: ComponentContext,
        alias: String
    ): CatalogComponent
}