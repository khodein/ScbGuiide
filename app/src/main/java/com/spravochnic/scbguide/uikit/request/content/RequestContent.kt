package com.spravochnic.scbguide.uikit.request.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.uikit.request.component.PreviewRequestComponent
import com.spravochnic.scbguide.uikit.request.component.RequestComponent
import com.spravochnic.scbguide.uikit.request.content.error.ErrorContent
import com.spravochnic.scbguide.uikit.request.content.progress.LoadingContent

@Composable
fun RequestContent(
    component: RequestComponent,
    modifier: Modifier = Modifier,
) {
    val stateValue by component.stateValue.subscribeAsState()

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        when (val state = stateValue) {
            is RequestComponent.State.Loading -> {
                LoadingContent(
                    modifier = Modifier.align(Alignment.Center),
                    requestState = state
                )
            }

            is RequestComponent.State.Error -> {
                ErrorContent(
                    modifier = Modifier.align(Alignment.Center),
                    reloadButtonItemComponent = component.buttonReloadValue,
                    requestState = state
                )
            }

            else -> Unit
        }
    }
}

@Preview
@Composable
private fun PreviewRequestContent() {
    RequestContent(
        modifier = Modifier.fillMaxSize(),
        component = PreviewRequestComponent()
    )
}