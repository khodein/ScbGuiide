package com.spravochnic.scbguide.rootcatalog.internal.content

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
import com.spravochnic.scbguide.rootcatalog.api.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.internal.content.title.HomeTitleContent
import com.spravochnic.scbguide.rootcatalog.internal.preview.PreviewRootCatalogComponent
import com.spravochnic.scbguide.uikit.navitem.NavItemContent
import com.spravochnic.scbguide.uikit.notice.NoticeItemContent
import com.spravochnic.scbguide.uikit.request.RequestContent
import com.spravochnic.scbguide.uikit.theme.color.Tertiary

@Composable
fun RootCatalogContent(
    component: RootCatalogComponent,
    modifier: Modifier = Modifier
) {
    val stateValue by component.stateValue.subscribeAsState()

    when (val state = stateValue) {
        is RootCatalogComponent.State.Request -> RequestChildContent(
            modifier = modifier,
            requestState = state
        )

        is RootCatalogComponent.State.Success -> {
            LazyColumn(
                modifier = modifier
            ) {
                items(state.list) { listComponent ->
                    when (listComponent) {
                        is RootCatalogComponent.Child.TitleChild -> TitleChildContent(
                            listComponent
                        )

                        is RootCatalogComponent.Child.NoticeChild -> NoticeChildContent(
                            listComponent
                        )

                        is RootCatalogComponent.Child.NavItemChild -> NavItemChildContent(
                            listComponent
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RequestChildContent(
    modifier: Modifier,
    requestState: RootCatalogComponent.State.Request
) {
    RequestContent(
        modifier = modifier,
        state = requestState.state,
    )
}

@Composable
private fun TitleChildContent(child: RootCatalogComponent.Child.TitleChild) {
    HomeTitleContent(
        state = child.state,
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
private fun NoticeChildContent(child: RootCatalogComponent.Child.NoticeChild) {
    NoticeItemContent(
        state = child.state,
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
private fun NavItemChildContent(child: RootCatalogComponent.Child.NavItemChild) {
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
        state = child.state
    )
}

@Preview
@Composable
internal fun RootCatalogContentPreview() {
    RootCatalogContent(PreviewRootCatalogComponent())
}