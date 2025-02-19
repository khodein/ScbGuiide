package com.spravochnic.scbguide.catalog.internal.mapper

import androidx.compose.ui.graphics.Color
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.api.model.CatalogModel
import com.spravochnic.scbguide.quest.api.model.QuestCatalogModel
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.theme.color.ICON_PRIMARY
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager

class CatalogStateMapperImpl(
    private val resManager: ResManager,
) : CatalogStateMapper {

    override fun mapCatalog(
        list: List<CatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)?
    ): CatalogComponent.Child.NavItemChild {
        val items = list.mapIndexed { index, model ->
            NavItemComponent.State(
                id = "${index}${model.type}",
                text = model.name,
                data = model,
                subText = "${model.count} устройств",
                leading = NavItemComponent.State.Leading(
                    res = R.drawable.ic_lectory,
                    tint = ICON_PRIMARY
                ),
                onClick = onClick
            )
        }

        return CatalogComponent.Child.NavItemChild(items)
    }

    override fun mapQuestCatalog(
        list: List<QuestCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)?
    ): CatalogComponent.Child.NavItemChild {
        val items = list.mapIndexed { index, model ->
            NavItemComponent.State(
                id = "${index}${model.type}",
                text = model.name,
                data = model,
                subText = "${model.count} вопросов",
                leading = NavItemComponent.State.Leading(
                    res = R.drawable.ic_lectory
                ),
                onClick = onClick
            )
        }

        return CatalogComponent.Child.NavItemChild(items)
    }

    override fun mapToolbarState(onClickArrow: () -> Unit): ToolbarComponent.State {
        return ToolbarComponent.State(
            leading = ToolbarComponent.Leading.Arrow(
                onClick = onClickArrow
            ),
            background = Color.Transparent
        )
    }
}