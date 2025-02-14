package com.spravochnic.scbguide.component.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.component.home.title.HomeTitleComponent
import com.spravochnic.scbguide.component.home.title.PreviewHomeTitleComponent
import com.spravochnic.scbguide.preview.PreviewComponentContext
import com.spravochnic.scbguide.uikit.navitem.component.PreviewNavItemComponent
import com.spravochnic.scbguide.uikit.notice.component.NoticeItemComponent
import com.spravochnic.scbguide.uikit.notice.component.PreviewNoticeItemComponent

class PreviewHomeComponent :
    HomeComponent,
    ComponentContext by PreviewComponentContext {

    override val titleHomeComponent: HomeTitleComponent by lazy {
        PreviewHomeTitleComponent()
    }
    override val noticeItemComponent: NoticeItemComponent by lazy {
        PreviewNoticeItemComponent()
    }

    private val loading = HomeComponent.State.Loading

    private val success = HomeComponent.State.Success(
        items = listOf(
            PreviewNavItemComponent(),
            PreviewNavItemComponent()
        )
    )

    override val stateValue: Value<HomeComponent.State> = MutableValue(
        loading
    )

    override fun onClickLectory() = Unit
    override fun onClickTest() = Unit
}