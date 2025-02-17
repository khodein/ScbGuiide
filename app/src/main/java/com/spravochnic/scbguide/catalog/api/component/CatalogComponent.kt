package com.spravochnic.scbguide.catalog.api.component

import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import kotlinx.serialization.Serializable

interface CatalogComponent {

    val rootCatalogTypeModel: RootCatalogTypeModel

    val initialState: State

    val toolbarStateValue: Value<ToolbarComponent.State>

    val stateValue: Value<State>

    @Serializable
    sealed class State {

        @Serializable
        data class Request(val state: RequestComponent.State) : State()

        @Serializable
        data class Success(val list: List<Child>) : State()
    }

    sealed interface Child {

    }
}