package com.spravochnic.scbguide.component.home

import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.component.home.title.HomeTitleComponent
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent
import com.spravochnic.scbguide.uikit.notice.component.NoticeItemComponent

interface HomeComponent {

    val titleHomeComponent: HomeTitleComponent
    val noticeItemComponent: NoticeItemComponent

    val stateValue: Value<State>

    fun onClickLectory()

    fun onClickTest()

    sealed class State {
        data object Loading: State()
        data class Success(val items: List<NavItemComponent>): State()
    }
}