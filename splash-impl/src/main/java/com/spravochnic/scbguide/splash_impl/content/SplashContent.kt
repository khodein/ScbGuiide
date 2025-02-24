package com.spravochnic.scbguide.splash_impl.content

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.splash_api.component.SplashComponent
import com.spravochnic.scbguide.splash_impl.preview.PreviewSplashComponent
import com.spravochnic.scbguide.uikit.theme.color.Primary
import kotlinx.coroutines.delay

@Composable
fun SplashContent(
    component: SplashComponent,
    modifier: Modifier = Modifier,
) {
    val state by component.state.subscribeAsState()

    Box(
        modifier = modifier
            .background(Primary),
        contentAlignment = Alignment.Center
    ) {
        val scale = remember { Animatable(0.0f) }

        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    }
                )
            )
            delay(state.duration)
            component.onFinish()
        }

        Image(
            painter = painterResource(state.backgroundRes),
            contentDescription = "Splash.Background",
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(state.imageCenterRes),
                contentDescription = "Splash.Center.Image",
                modifier = Modifier
                    .size(100.dp)
                    .scale(scale.value)
            )
            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                text = stringResource(state.centerTextRes),
                style = com.spravochnic.scbguide.uikit.theme.style.Bold_22,
                color = com.spravochnic.scbguide.uikit.theme.color.Secondary,
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .systemBarsPadding()
                .padding(
                    bottom = 24.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            style = com.spravochnic.scbguide.uikit.theme.style.Regular_12,
            textAlign = TextAlign.Center,
            text = stringResource(state.footerTextRes),
            color = com.spravochnic.scbguide.uikit.theme.color.TextPrimary,
        )
    }
}

@Preview
@Composable
internal fun SplashContentPreview() {
    SplashContent(PreviewSplashComponent())
}