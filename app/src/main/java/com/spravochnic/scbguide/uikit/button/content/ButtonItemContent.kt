package com.spravochnic.scbguide.uikit.button.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.uikit.button.component.ButtonItemComponent
import com.spravochnic.scbguide.uikit.button.component.PreviewButtonItemComponent
import com.spravochnic.scbguide.uikit.theme.style.Bold_16

@Composable
fun ButtonItemContent(
    component: ButtonItemComponent,
    modifier: Modifier = Modifier,
) {
    val state by component.stateValue.subscribeAsState()

    val fill = state.fill
    val border = when (fill) {
        is ButtonItemComponent.Fill.Outline -> BorderStroke(
            width = fill.strokeWidth,
            color = fill.strokeColor
        )

        else -> null
    }

    Button(
        modifier = modifier.wrapContentHeight(),
        contentPadding = PaddingValues(
            horizontal = 32.dp,
            vertical = 16.dp
        ),
        colors = ButtonDefaults.buttonColors().copy(containerColor = fill.background),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        border = border,
        onClick = { state.onClick?.invoke() }
    ) {
        Text(
            text = state.text,
            style = Bold_16,
            color = fill.textColor
        )
    }
}

@Preview
@Composable
fun PreviewButtonItemContent() {
    ButtonItemContent(
        PreviewButtonItemComponent()
    )
}