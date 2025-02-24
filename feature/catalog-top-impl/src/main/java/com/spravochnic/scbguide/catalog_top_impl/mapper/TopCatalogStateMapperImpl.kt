package com.spravochnic.scbguide.catalog_top_impl.mapper

import androidx.compose.ui.graphics.Color
import com.spravochnic.scbguide.catalog_top_api.component.TopCatalogComponent
import com.spravochnic.scbguide.catalog_top_api.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.lectory_api.model.TopLectoryCatalogModel
import com.spravochnic.scbguide.quest_api.model.TopQuestCatalogModel
import com.spravochnic.scbguide.root_api.utils.ResManager
import com.spravochnic.scbguide.uikit.R
import com.spravochnic.scbguide.uikit.navitem.NavItemComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent

class TopCatalogStateMapperImpl(
    private val resManager: ResManager,
) : TopCatalogStateMapper {

    override fun mapCatalog(
        list: List<TopLectoryCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)?
    ): TopCatalogComponent.Child.NavItemChild {
        val items = list.mapIndexed { index, model ->
            NavItemComponent.State(
                id = "${index}${model.type}",
                text = model.name,
                data = model,
                subText = "${model.count} устройств",
                leading = NavItemComponent.State.Leading(
                    res = R.drawable.ic_lectory,
                    tint = com.spravochnic.scbguide.uikit.theme.color.ICON_PRIMARY
                ),
                onClick = onClick
            )
        }

        return TopCatalogComponent.Child.NavItemChild(items)
    }

    override fun mapQuestCatalog(
        list: List<TopQuestCatalogModel>,
        onClick: ((state: NavItemComponent.State) -> Unit)?
    ): TopCatalogComponent.Child.NavItemChild {
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

        return TopCatalogComponent.Child.NavItemChild(items)
    }

    override fun mapToolbarCatalog(
        onClickArrow: () -> Unit
    ): TopCatalogComponent.ToolbarChild {
        return TopCatalogComponent.ToolbarChild(
            toolbarState = ToolbarComponent.State(
                leading = ToolbarComponent.Leading.Arrow(
                    onClick = onClickArrow,
                ),
                background = Color.Transparent
            ),
            imageRes = R.drawable.art_top_lectory

        )
    }

    override fun mapToolbarQuestCatalog(
        onClickArrow: () -> Unit
    ): TopCatalogComponent.ToolbarChild {
        return TopCatalogComponent.ToolbarChild(
            toolbarState = ToolbarComponent.State(
                leading = ToolbarComponent.Leading.Arrow(
                    onClick = onClickArrow,
                ),
                background = Color.Transparent
            ),
            imageRes = R.drawable.art_top_quest
        )
    }
}