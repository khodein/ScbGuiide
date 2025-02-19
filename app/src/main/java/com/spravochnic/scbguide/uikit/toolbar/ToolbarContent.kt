package com.spravochnic.scbguide.uikit.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.uikit.theme.style.Bold_16

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarContent(
    modifier: Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    state: ToolbarComponent.State,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        modifier = modifier,
        colors = colors,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            when (val leading = state.leading) {
                is ToolbarComponent.Leading.Arrow -> {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .clickable {
                                leading.onClick?.invoke()
                            }
                            .padding(horizontal = 20.dp)
                    ) {
                        Image(
                            painter = painterResource(leading.res),
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.Center),
                            contentDescription = "ToolbarContent.LeadingIcon",
                            colorFilter = ColorFilter.tint(leading.tint),
                        )
                    }
                }

                else -> {

                }
            }
        },
        title = {
            state.title?.let { title ->
                Text(
                    text = title.text,
                    color = title.textColor,
                    style = Bold_16,
                )
            }
        },
    )
}