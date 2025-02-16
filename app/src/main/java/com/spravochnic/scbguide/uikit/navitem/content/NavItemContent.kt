package com.spravochnic.scbguide.uikit.navitem.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent
import com.spravochnic.scbguide.uikit.navitem.component.PreviewNavItemComponent
import com.spravochnic.scbguide.uikit.theme.color.Tertiary
import com.spravochnic.scbguide.uikit.theme.color.TextPrimary
import com.spravochnic.scbguide.uikit.theme.color.TextTertiary
import com.spravochnic.scbguide.uikit.theme.style.ExtraBold_15
import com.spravochnic.scbguide.uikit.theme.style.Regular_13

@Composable
fun NavItemContent(
    component: NavItemComponent,
    modifier: Modifier = Modifier,
) {
    val state by component.stateValue.subscribeAsState()

    Row(
        modifier = modifier
            .padding(20.dp)
            .clickable { state.onClick?.invoke(state) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        state.leading?.let { leading ->
            Image(
                modifier = Modifier.size(48.dp),
                contentDescription = "NavItem.Leading.Icon",
                colorFilter = ColorFilter.tint(leading.tint),
                painter = painterResource(leading.res),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .padding(horizontal = 20.dp)
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = state.text,
                style = ExtraBold_15,
                color = TextPrimary,
                textAlign = TextAlign.Left
            )

            state.subText?.let { subText ->
                Text(
                    text = subText,
                    style = Regular_13,
                    color = TextTertiary,
                    textAlign = TextAlign.Left
                )
            }
        }

        state.trailing?.let { trailing ->
            when (trailing) {
                is NavItemComponent.State.Trailing.Arrow -> {
                    Image(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(trailing.res),
                        contentDescription = "NavItem.Trailing.Arrow",
                        colorFilter = ColorFilter.tint(trailing.tint)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
internal fun NavItemContentPreview() {
    NavItemContent(
        component = PreviewNavItemComponent(),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(CircleShape.copy(CornerSize(20.dp)))
            .shadow(elevation = 4.dp)
            .background(color = Tertiary)
    )
}