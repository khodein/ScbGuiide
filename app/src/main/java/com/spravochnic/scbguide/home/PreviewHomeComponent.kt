package com.spravochnic.scbguide.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.home.title.PreviewHomeTitleComponent
import com.spravochnic.scbguide.uikit.navitem.component.PreviewNavItemComponent
import com.spravochnic.scbguide.uikit.notice.component.PreviewNoticeItemComponent
import com.spravochnic.scbguide.uikit.request.component.PreviewRequestComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewHomeComponent :
    HomeComponent,
    ComponentContext by PreviewComponentContext {

    private val request = HomeComponent.State.Request(PreviewRequestComponent())

    override val initialState: HomeComponent.State = HomeComponent.State.Success(
        list = listOf(
            HomeComponent.Child.TitleChild(PreviewHomeTitleComponent()),
            HomeComponent.Child.NoticeChild(PreviewNoticeItemComponent()),
            HomeComponent.Child.NavItemChild(PreviewNavItemComponent()),
            HomeComponent.Child.NavItemChild(PreviewNavItemComponent())
        )
    )

    override val stateValue: Value<HomeComponent.State> = MutableValue(request)
}