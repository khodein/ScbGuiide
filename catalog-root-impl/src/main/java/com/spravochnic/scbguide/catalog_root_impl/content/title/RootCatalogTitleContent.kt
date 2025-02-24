package com.spravochnic.scbguide.catalog_root_impl.content.title

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.catalog_root_api.component.RootCatalogTitleComponent
import com.spravochnic.scbguide.uikit.R
import com.spravochnic.scbguide.uikit.theme.color.TextPrimary
import com.spravochnic.scbguide.uikit.theme.color.TextSecondary
import com.spravochnic.scbguide.uikit.theme.style.Bold_16

@Composable
fun HomeTitleContent(
    state: RootCatalogTitleComponent.State,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = state.title,
            style = Bold_16,
            color = TextPrimary,
        )

        state.subTitle?.let { sub ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(sub.leadingRes),
                    contentDescription = "RootCatalogTitle.Sub.Leading.Icon",
                )

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight()
                        .padding(start = 4.dp),
                    text = sub.text,
                    style = Bold_16,
                    color = TextSecondary
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeTitleContent() {
    HomeTitleContent(
        RootCatalogTitleComponent.State(
            title = "Title",
            subTitle = RootCatalogTitleComponent.State.SubTitle(
                text = "Subtitle",
                leadingRes = R.drawable.ic_award
            )
        )
    )
}