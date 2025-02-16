package com.spravochnic.scbguide.home

import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.home.title.HomeTitleComponent
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent
import com.spravochnic.scbguide.uikit.notice.component.NoticeItemComponent
import com.spravochnic.scbguide.uikit.request.component.RequestComponent
import kotlinx.serialization.Serializable

interface HomeComponent {

    val stateValue: Value<State>

    val initialState: State

    @Serializable
    sealed class State {
        @Serializable
        data class Request(val component: RequestComponent) : State()

        @Serializable
        data class Success(val list: List<Child>) : State()
    }

    sealed interface Child {
        data class TitleChild(val titleHomeComponent: HomeTitleComponent) : Child
        data class NoticeChild(val noticeItemComponent: NoticeItemComponent) : Child
        data class NavItemChild(val navItemComponent: NavItemComponent) : Child
    }
}