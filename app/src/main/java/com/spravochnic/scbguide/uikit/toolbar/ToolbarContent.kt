package com.spravochnic.scbguide.uikit.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.uikit.theme.style.Bold_16

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarContent(
    modifier: Modifier,
    state: ToolbarComponent.State,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    TopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            state.leading?.let { leading ->
                Image(
                    painter = painterResource(leading.res),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "ToolbarContent.LeadingIcon",
                    colorFilter = ColorFilter.tint(leading.tint),
                )
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