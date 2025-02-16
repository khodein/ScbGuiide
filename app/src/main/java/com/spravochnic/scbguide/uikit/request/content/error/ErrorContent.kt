package com.spravochnic.scbguide.uikit.request.content.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.spravochnic.scbguide.uikit.button.component.ButtonItemComponent
import com.spravochnic.scbguide.uikit.button.content.ButtonItemContent
import com.spravochnic.scbguide.uikit.request.component.RequestComponent
import com.spravochnic.scbguide.uikit.theme.style.Bold_16

@Composable
fun ErrorContent(
    modifier: Modifier,
    reloadButtonItemComponent: ButtonItemComponent,
    requestState: RequestComponent.State.Error,
) {
    Column(
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 60.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                modifier = Modifier
                    .size(requestState.errorImageSize)
                    .align(Alignment.CenterVertically),
                painter = painterResource(requestState.errorRes),
                alpha = 0.8f,
                colorFilter = ColorFilter.colorMatrix(OrangeColorMatrix.get()),
                contentDescription = "Error.Image"
            )

            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp),
                textAlign = TextAlign.Center,
                text = requestState.message,
                style = Bold_16,
                color = requestState.messageColor
            )
        }

        ButtonItemContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, end = 60.dp, top = 20.dp)
                .align(Alignment.CenterHorizontally),
            component = reloadButtonItemComponent
        )
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