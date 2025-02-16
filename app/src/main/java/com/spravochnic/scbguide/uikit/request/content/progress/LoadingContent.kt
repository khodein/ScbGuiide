package com.spravochnic.scbguide.uikit.request.content.progress

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.uikit.request.component.RequestComponent

@Composable
fun LoadingContent(
    modifier: Modifier,
    requestState: RequestComponent.State.Loading,
) {
    CircularProgressIndicator(
        modifier = modifier.size(40.dp),
        trackColor = requestState.trackColor,
        strokeWidth = requestState.strokeWidth
    )
}