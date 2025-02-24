package com.spravochnic.scbguide.catalog_top_impl.mapper

import androidx.compose.ui.graphics.Color
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.catalog_top_api.component.TopCatalogComponent
import com.spravochnic.scbguide.catalog_top_api.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.lectory.api.model.TopLectoryCatalogModel
import com.spravochnic.scbguide.quest.api.model.TopQuestCatalogModel
import com.spravochnic.scbguide.root_api.utils.ResManager

class TopCatalogStateMapperImpl(
    private val resManager: ResManager,
) : TopCatalogStateMapper {

    override fun mapCatalog(
        list: List<TopLectoryCatalogModel>,
        onClick: ((state: com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State) -> Unit)?
    ): TopCatalogComponent.Child.NavItemChild {
        val items = list.mapIndexed { index, model ->
            com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State(
                id = "${index}${model.type}",
                text = model.name,
                data = model,
                subText = "${model.count} устройств",
                leading = com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State.Leading(
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
        onClick: ((state: com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State) -> Unit)?
    ): TopCatalogComponent.Child.NavItemChild {
        val items = list.mapIndexed { index, model ->
            com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State(
                id = "${index}${model.type}",
                text = model.name,
                data = model,
                subText = "${model.count} вопросов",
                leading = com.spravochnic.scbguide.uikit.navitem.NavItemComponent.State.Leading(
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
            toolbarState = com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent.State(
                leading = com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent.Leading.Arrow(
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
            toolbarState = com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent.State(
                leading = com.spravochnic.scbguide.uikit.toolbar.ToolbarComponent.Leading.Arrow(
                    onClick = onClickArrow,
                ),
                background = Color.Transparent
            ),
            imageRes = R.drawable.art_top_quest
        )
    }
}