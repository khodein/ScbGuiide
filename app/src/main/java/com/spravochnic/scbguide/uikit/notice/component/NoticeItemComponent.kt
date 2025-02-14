package com.spravochnic.scbguide.uikit.notice.component

import com.arkivanov.decompose.value.Value

interface NoticeItemComponent {

    val stateValue: Value<State>

    data class State(
        val title: String,
        val description: String,
    )
}