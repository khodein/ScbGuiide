package com.spravochnic.scbguide.rootcatalog.internal.preview

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.internal.content.title.RootCatalogTitleComponent
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.notice.NoticeItemComponent
import com.spravochnic.scbguide.uikit.request.RequestComponent
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewRootCatalogComponent :
    RootCatalogComponent,
    ComponentContext by PreviewComponentContext {

    override val stateValue: Value<RootCatalogComponent.State> by lazy {
        MutableValue(
            RootCatalogComponent.State.Request(
                state = RequestComponent.State.Error(
                    message = "Ошибка!"
                )
            )
        )
    }

    override val initialState: RootCatalogComponent.State = RootCatalogComponent.State.Success(
        list = listOf(
            RootCatalogComponent.Child.TitleChild(
                RootCatalogTitleComponent.State(
                    title = "Title",
                    subTitle = RootCatalogTitleComponent.State.SubTitle(
                        text = "Subtitle",
                        leadingRes = R.drawable.ic_award
                    )
                )
            ),
            RootCatalogComponent.Child.NoticeChild(
                NoticeItemComponent.State(
                    title = "Slskdksdklsklsdklsd",
                    description = "skdkjsdjkskjsdksjdjksdjksdjksdsjkdjksdjsdk\nsjkdkkjsdkjsdjkslsdlkskdlklsdklsdkldsklsdklsdklsdsdkldsklsdklsdklsdklsdklsdklsdklsdklsdklskdlsdklskldskldskldklsddklklsdklsdklsdklsdklsdklsdklsdklsdklsdksldklsdklsdklsdklsdklsdlksdlksdsdlklksdklsdlksdlksdklsdklsdlksdkldskldskldskldslk"
                )
            ),
            RootCatalogComponent.Child.NavItemChild(
                NavItemComponent.State(
                    id = "",
                    text = "Лекторий",
                    subText = "3 уровня",
                    leading = NavItemComponent.State.Leading(
                        res = R.drawable.ic_splash,
                        tint = Note
                    ),
                    trailing = NavItemComponent.State.Trailing.Arrow()
                )
            ),
            RootCatalogComponent.Child.NavItemChild(
                NavItemComponent.State(
                    id = "",
                    text = "Лекторий",
                    subText = "3 уровня",
                    leading = NavItemComponent.State.Leading(
                        res = R.drawable.ic_splash,
                        tint = Note
                    ),
                    trailing = NavItemComponent.State.Trailing.Arrow()
                )
            )
        )
    )
}