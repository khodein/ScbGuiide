package com.spravochnic.scbguide.catalog.component

import com.arkivanov.decompose.ComponentContext

class DefaultCatalogComponent(
    componentContext: ComponentContext,
) : CatalogComponent, ComponentContext by componentContext {


}