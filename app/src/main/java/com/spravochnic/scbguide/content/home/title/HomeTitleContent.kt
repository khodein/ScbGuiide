package com.spravochnic.scbguide.content.home.title

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.component.home.title.HomeTitleComponent
import com.spravochnic.scbguide.component.home.title.PreviewHomeTitleComponent
import com.spravochnic.scbguide.ui.color.TextPrimary
import com.spravochnic.scbguide.ui.color.TextSecondary
import com.spravochnic.scbguide.ui.style.Bold_16

@Composable
fun HomeTitleContent(
    component: HomeTitleComponent,
    modifier: Modifier = Modifier,
) {
    val state by component.stateValue.subscribeAsState()

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
                    contentDescription = "HomeTitle.Sub.Leading.Icon",
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
internal fun PreviewHomeTitleContent() {
    HomeTitleContent(PreviewHomeTitleComponent())
}