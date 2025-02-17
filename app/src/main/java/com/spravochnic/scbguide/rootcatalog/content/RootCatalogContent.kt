package com.spravochnic.scbguide.rootcatalog.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.rootcatalog.component.PreviewRootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.component.title.RootCatalogTitleComponent
import com.spravochnic.scbguide.rootcatalog.content.title.HomeTitleContent
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent
import com.spravochnic.scbguide.uikit.navitem.content.NavItemContent
import com.spravochnic.scbguide.uikit.notice.component.NoticeItemComponent
import com.spravochnic.scbguide.uikit.notice.content.NoticeItemContent
import com.spravochnic.scbguide.uikit.request.content.RequestContent
import com.spravochnic.scbguide.uikit.theme.color.Tertiary

@Composable
fun RootCatalogContent(
    component: RootCatalogComponent,
    modifier: Modifier = Modifier
) {
    val stateValue by component.stateValue.subscribeAsState()

    when (val state = stateValue) {
        is RootCatalogComponent.State.Request -> {
            RequestContent(
                modifier = modifier,
                component = state.component,
            )
        }

        is RootCatalogComponent.State.Success -> {
            LazyColumn(
                modifier = modifier
            ) {
                items(state.list) { listComponent ->
                    when (listComponent) {
                        is RootCatalogComponent.Child.TitleChild -> TitleChildContent(listComponent.titleRootCatalogComponent)
                        is RootCatalogComponent.Child.NoticeChild -> NoticeChildContent(
                            listComponent.noticeItemComponent
                        )

                        is RootCatalogComponent.Child.NavItemChild -> NavItemChildContent(
                            listComponent.navItemComponent
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TitleChildContent(component: RootCatalogTitleComponent) {
    HomeTitleContent(
        component = component,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
            )
    )
}

@Composable
private fun NoticeChildContent(component: NoticeItemComponent) {
    NoticeItemContent(
        component = component,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp
            )
    )
}

@Composable
private fun NavItemChildContent(component: NavItemComponent) {
    NavItemContent(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .height(100.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                color = Tertiary,
                shape = RoundedCornerShape(20.dp)
            ),
        component = component
    )
}

@Preview
@Composable
internal fun RootCatalogContentPreview() {
    RootCatalogContent(PreviewRootCatalogComponent())
}