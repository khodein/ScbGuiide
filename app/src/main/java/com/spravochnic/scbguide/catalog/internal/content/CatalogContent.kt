package com.spravochnic.scbguide.catalog.internal.content

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.internal.preview.PreviewCatalogComponent
import com.spravochnic.scbguide.uikit.navitem.NavItemContent
import com.spravochnic.scbguide.uikit.request.RequestContent
import com.spravochnic.scbguide.uikit.theme.color.Tertiary
import com.spravochnic.scbguide.uikit.toolbar.ToolbarContent

@Composable
fun CatalogContent(
    component: CatalogComponent,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()

    val firstVisibleItemIndex = remember { derivedStateOf { lazyListState.firstVisibleItemIndex } }

    val scrollProgress = if (firstVisibleItemIndex.value == 0) {
        firstVisibleItemIndex.value / 200f
    } else {
        1f
    }.coerceIn(0f, 1f)

    val imageState = remember { mutableStateOf(ImageCollapseState.EXPANDED) }

    LaunchedEffect(firstVisibleItemIndex) {
        if (scrollProgress >= 1f) {
            imageState.value = ImageCollapseState.COLLAPSED
        } else {
            imageState.value = ImageCollapseState.EXPANDED
        }
    }

    val animatedHeight by animateDpAsState(
        targetValue = (200.dp - (scrollProgress * 200.dp)),
        animationSpec = tween(durationMillis = 200)
    )

    val animatedScaleY by animateFloatAsState(
        targetValue = 1f - scrollProgress * 0.5f,
        animationSpec = tween(durationMillis = 200)
    )

    val animatedAlpha by animateFloatAsState(
        targetValue = 1f - scrollProgress,
        animationSpec = tween(durationMillis = 200)
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                val toolbarStateValue by component.toolbarStateValue.subscribeAsState()

                ToolbarContent(
                    modifier = Modifier
                        .fillMaxWidth(),
                    state = toolbarStateValue.toolbarState,
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(animatedHeight)
                        .graphicsLayer {
                            scaleY = animatedScaleY
                            alpha = animatedAlpha
                        },
                    painter = painterResource(toolbarStateValue.imageRes),
                    contentDescription = "Catalog.Image.Art"
                )
            }
        }
    ) { paddings ->

        val stateValue by component.stateValue.subscribeAsState()

        when (val state = stateValue) {
            is CatalogComponent.State.Request -> {
                RequestContent(
                    modifier = Modifier.fillMaxSize(),
                    state = state.state
                )
            }

            is CatalogComponent.State.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddings),
                    state = lazyListState
                ) {
                    when (val child = state.child) {
                        is CatalogComponent.Child.NavItemChild -> this.navItemContentItems(child)
                    }
                }
            }
        }
    }
}

private fun LazyListScope.navItemContentItems(
    child: CatalogComponent.Child.NavItemChild
) {
    itemsIndexed(child.items) { index, item ->
        val bottomPadding = if ((child.items.size - 1) == index) {
            20
        } else {
            0
        }

        NavItemContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp,
                    bottom = bottomPadding.dp
                )
                .height(100.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = Tertiary,
                    shape = RoundedCornerShape(20.dp)
                ),
            state = item
        )
    }
}

private enum class ImageCollapseState {
    EXPANDED,
    COLLAPSED
}

@Preview
@Composable
private fun PreviewCatalogContent() {
    CatalogContent(PreviewCatalogComponent())
}