package com.spravochnic.scbguide.rootcatalog.component.title

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultRootCatalogTitleComponent(
    initialState: RootCatalogTitleComponent.State,
    componentContext: ComponentContext
) : RootCatalogTitleComponent, ComponentContext by componentContext {

    private val _stateValue = MutableValue(initialState)
    override val stateValue: Value<RootCatalogTitleComponent.State> = _stateValue

    override fun update(state: RootCatalogTitleComponent.State) {
        _stateValue.update { state }
    }
}