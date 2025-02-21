package com.spravochnic.scbguide.catalogroot.api.component

import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.catalogroot.impl.content.title.RootCatalogTitleComponent
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.notice.NoticeItemComponent
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.serialization.Serializable

interface RootCatalogComponent {

    val stateValue: Value<State>

    val initialState: State

    @Serializable
    sealed class State {
        @Serializable
        data class Request(val state: RequestComponent.State) : State()

        @Serializable
        data class Success(val list: List<Child>) : State()
    }

    sealed interface Child {
        data class TitleChild(val state: RootCatalogTitleComponent.State) : Child
        data class NoticeChild(val state: NoticeItemComponent.State) : Child
        data class NavItemChild(val state: NavItemComponent.State) : Child
    }
}