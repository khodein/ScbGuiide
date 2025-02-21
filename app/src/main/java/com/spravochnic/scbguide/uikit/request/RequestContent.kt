package com.spravochnic.scbguide.uikit.request

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RequestContent(
    state: RequestComponent.State,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is RequestComponent.State.Loading -> {
                LoadingContent(
                    modifier = Modifier.align(Alignment.Center),
                    requestState = state
                )
            }

            is RequestComponent.State.Error -> {
                ErrorContent(
                    modifier = Modifier.align(Alignment.Center),
                    requestState = state
                )
            }

            is RequestComponent.State.Empty -> {
                EmptyContent(
                    modifier = Modifier.align(Alignment.Center),
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
        state = RequestComponent.State.Empty(
            message = "Error",
            buttonReloadMessage = "Update?",
            onReloadClick = {

            }
        )
    )
}