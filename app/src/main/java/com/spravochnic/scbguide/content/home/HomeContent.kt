package com.spravochnic.scbguide.content.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.component.home.HomeComponent
import com.spravochnic.scbguide.component.home.PreviewHomeComponent
import com.spravochnic.scbguide.content.home.title.HomeTitleContent
import com.spravochnic.scbguide.ui.color.Primary
import com.spravochnic.scbguide.ui.color.Tertiary
import com.spravochnic.scbguide.uikit.navitem.content.NavItemContent
import com.spravochnic.scbguide.uikit.notice.content.NoticeItemContent

@Composable
fun HomeContent(
    component: HomeComponent,
    modifier: Modifier = Modifier
) {
    val stateValue by component.stateValue.subscribeAsState()

    LazyColumn(
        modifier = modifier
    ) {
        item {
            HomeTitleContent(
                component = component.titleHomeComponent,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 20.dp,
                    )
            )
        }

        item {
            NoticeItemContent(
                component = component.noticeItemComponent,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 20.dp
                    )
            )
        }

        when (val state = stateValue) {
            is HomeComponent.State.Loading -> {
                item {
                    Box(
                        modifier = Modifier.size(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedProgressBar()
                    }
                }
            }

            is HomeComponent.State.Success -> {
                items(state.items) { item ->
                    NavItemContent(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                            .height(100.dp)
                            .clip(CircleShape.copy(CornerSize(20.dp)))
                            .shadow(elevation = 4.dp)
                            .background(color = Tertiary),
                        component = item
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedProgressBar() {
    val animatedProgress by animateFloatAsState(
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000)
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp * animatedProgress),
            color = Primary,
            strokeWidth = 4.dp
        )
    }
}

@Preview
@Composable
internal fun HomeContentPreview() {
    HomeContent(PreviewHomeComponent())
}