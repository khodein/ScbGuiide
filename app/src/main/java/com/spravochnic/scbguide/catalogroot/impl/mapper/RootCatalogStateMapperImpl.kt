package com.spravochnic.scbguide.catalogroot.impl.mapper

import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.catalogroot.api.component.RootCatalogComponent
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogListModel
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.catalogroot.impl.content.title.RootCatalogTitleComponent
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.notice.NoticeItemComponent
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.utils.resmanager.ResManager

class RootCatalogStateMapperImpl(
    private val resManager: ResManager,
) : RootCatalogStateMapper {

    override fun map(
        model: RootCatalogListModel,
        onClick: ((state: NavItemComponent.State) -> Unit),
    ): List<RootCatalogComponent.Child> {
        val titleItem = RootCatalogComponent.Child.TitleChild(
            RootCatalogTitleComponent.State(
                title = resManager.getString(R.string.default_home_title_text),
                subTitle = RootCatalogTitleComponent.State.SubTitle(
                    text = model.count,
                    leadingRes = R.drawable.ic_award
                )
            )
        )

        val noticeItem = RootCatalogComponent.Child.NoticeChild(
            NoticeItemComponent.State(
                title = resManager.getString(R.string.default_home_notice_title_text),
                description = resManager.getString(R.string.default_home_notice_description_text)
            )
        )

        val navItems = model.list.map { item ->
            val leadingResId = when (item.type) {
                RootCatalogTypeModel.LECTORY -> R.drawable.ic_lectory
                RootCatalogTypeModel.QUEST -> R.drawable.ic_quest
            }
            RootCatalogComponent.Child.NavItemChild(
                NavItemComponent.State(
                    id = "${item.id}${item.type}",
                    text = item.title,
                    subText = item.subName,
                    data = item,
                    leading = NavItemComponent.State.Leading(
                        res = leadingResId,
                        tint = Note
                    ),
                    trailing = NavItemComponent.State.Trailing.Arrow(tint = Note),
                    onClick = onClick
                )
            )
        }

        return buildList(10) {
            add(titleItem)
            add(noticeItem)
            addAll(navItems)
        }
    }
}