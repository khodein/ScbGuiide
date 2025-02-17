package com.spravochnic.scbguide.uikit.notice

interface NoticeItemComponent {

    data class State(
        val title: String,
        val description: String,
    )
}