package com.spravochnic.scbguide.catalog

import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import kotlinx.serialization.Serializable

interface CatalogComponent {

    val toolbarStateValue: Value<ToolbarComponent.State>

    val stateValue: Value<State>

    @Serializable
    sealed class State {
        data class Request(val state: RequestComponent.State) : State()
        data class Success(val list: List<Child>) : State()
    }

    sealed interface Child {

    }
}