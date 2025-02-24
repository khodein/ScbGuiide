package com.spravochnic.scbguide.catalog_root_impl.mapper

import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.catalog_root_api.component.RootCatalogTitleComponent
import com.spravochnic.scbguide.root_api.utils.ResManager

class RootCatalogStateMapperImpl(
    private val resManager: ResManager,
) : RootCatalogStateMapper {

    override fun map(
        model: com.spravochnic.scbguide.catalog_root_api.model.RootCatalogListModel,
        onClick: ((state: com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State) -> Unit),
    ): List<com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent.Child> {
        val titleItem = com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent.Child.TitleChild(
            RootCatalogTitleComponent.State(
                title = resManager.getString(R.string.default_home_title_text),
                subTitle = RootCatalogTitleComponent.State.SubTitle(
                    text = model.count,
                    leadingRes = R.drawable.ic_award
                )
            )
        )

        val noticeItem = com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent.Child.NoticeChild(
            com.spravochnic.scbguide.uikit.notice.NoticeItemComponent.State(
                title = resManager.getString(R.string.default_home_notice_title_text),
                description = resManager.getString(R.string.default_home_notice_description_text)
            )
        )

        val navItems = model.list.map { item ->
            val leadingResId = when (item.type) {
                com.spravochnic.scbguide.catalog_root_api.model.RootCatalogTypeModel.LECTORY -> R.drawable.ic_lectory
                com.spravochnic.scbguide.catalog_root_api.model.RootCatalogTypeModel.QUEST -> R.drawable.ic_quest
            }
            com.spravochnic.scbguide.catalog_root_api.component.RootCatalogComponent.Child.NavItemChild(
                com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State(
                    id = "${item.id}${item.type}",
                    text = item.title,
                    subText = item.subName,
                    data = item,
                    leading = com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State.Leading(
                        res = leadingResId,
                        tint = com.spravochnic.scbguide.uikit.theme.color.Note
                    ),
                    trailing = com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State.Trailing.Arrow(tint = com.spravochnic.scbguide.uikit.theme.color.Note),
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