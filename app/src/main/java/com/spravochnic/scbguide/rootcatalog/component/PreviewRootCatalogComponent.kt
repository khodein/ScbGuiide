package com.spravochnic.scbguide.rootcatalog.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.rootcatalog.component.title.PreviewRootCatalogTitleComponent
import com.spravochnic.scbguide.uikit.navitem.component.PreviewNavItemComponent
import com.spravochnic.scbguide.uikit.notice.component.PreviewNoticeItemComponent
import com.spravochnic.scbguide.uikit.request.component.PreviewRequestComponent
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewRootCatalogComponent :
    RootCatalogComponent,
    ComponentContext by PreviewComponentContext {

    private val request = RootCatalogComponent.State.Request(PreviewRequestComponent())

    override val initialState: RootCatalogComponent.State = RootCatalogComponent.State.Success(
        list = listOf(
            RootCatalogComponent.Child.TitleChild(PreviewRootCatalogTitleComponent()),
            RootCatalogComponent.Child.NoticeChild(PreviewNoticeItemComponent()),
            RootCatalogComponent.Child.NavItemChild(PreviewNavItemComponent()),
            RootCatalogComponent.Child.NavItemChild(PreviewNavItemComponent())
        )
    )

    override val stateValue: Value<RootCatalogComponent.State> = MutableValue(request)
}