package com.spravochnic.scbguide.uikit.request

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.uikit.button.ButtonItemComponent
import com.spravochnic.scbguide.uikit.button.ButtonItemContent
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.uikit.theme.color.TextPrimaryInverse
import com.spravochnic.scbguide.uikit.theme.style.Bold_16

@Composable
fun ErrorContent(
    modifier: Modifier,
    requestState: RequestComponent.State.Error,
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth(),
        verticalArrangement = Arrangement.Center,
    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 60.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                modifier = Modifier
                    .size(requestState.errorImageSize)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(requestState.errorRes),
                alpha = 0.8f,
                colorFilter = ColorFilter.colorMatrix(OrangeColorMatrix.get()),
                contentDescription = "Error.Image"
            )

            Text(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 10.dp),
                textAlign = TextAlign.Center,
                text = requestState.message,
                style = Bold_16,
                color = requestState.messageColor
            )
        }

        if (!requestState.buttonReloadMessage.isNullOrEmpty() && requestState.onReloadClick != null) {
            ButtonItemContent(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .width(250.dp)
                    .align(Alignment.CenterHorizontally),
                state = ButtonItemComponent.State(
                    id = "error_content_button_reload",
                    text = requestState.buttonReloadMessage,
                    onClick = requestState.onReloadClick,
                    fill = ButtonItemComponent.Fill.Custom(
                        background = Note,
                        textColor = TextPrimaryInverse
                    )
                )
            )
        }
    }
}

private object OrangeColorMatrix {
    private val matrix = floatArrayOf(
        0.6f, 0.4f, 0.0f, 0.0f, 0.1f,
        0.4f, 0.3f, 0.0f, 0.0f, 0.1f,
        0.0f, 0.0f, 0.1f, 0.0f, 0.0f,
        0.0f, 0.0f, 0.0f, 1.0f, 0.0f
    )

    fun get(): ColorMatrix {
        return ColorMatrix(matrix)
    }
}