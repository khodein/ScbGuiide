package com.spravochnic.scbguide.rootcatalog.mapper

import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogModel
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogTypeModel
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.utils.resmanager.ResManager

class RootCatalogComponentMapperImpl(
    private val resManager: ResManager,
) : RootCatalogComponentMapper {

    override fun map(
        list: List<RootCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)
    ): List<NavItemComponent.State> {
        return list.map { item ->
            val leadingResId = when (item.type) {
                RootCatalogTypeModel.LECTORY -> R.drawable.ic_lectory
                RootCatalogTypeModel.QUEST -> R.drawable.ic_quest
            }
            NavItemComponent.State(
                id = "${item.id}${item.type}",
                text = item.title,
                subText = item.subName,
                data = item,
                leading = NavItemComponent.State.Leading(
                    res = leadingResId,
                    tint = Note
                ),
                trailing = NavItemComponent.State.Trailing.Arrow(),
                onClick = onClick
            )
        }
    }
}