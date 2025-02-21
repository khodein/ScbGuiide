package com.spravochnic.scbguide.catalogtop.api.component

import androidx.annotation.DrawableRes
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import kotlinx.serialization.Serializable

interface TopCatalogComponent {

    val initialState: State

    val toolbarStateValue: Value<ToolbarChild>

    val stateValue: Value<State>

    @Serializable
    sealed class State {

        @Serializable
        data class Request(val state: RequestComponent.State) : State()

        @Serializable
        data class Success(val child: Child) : State()
    }

    data class ToolbarChild(
        val toolbarState: ToolbarComponent.State,
        @DrawableRes val imageRes: Int
    )

    sealed interface Child {
        data class NavItemChild(val items: List<NavItemComponent.State>) : Child
    }
}