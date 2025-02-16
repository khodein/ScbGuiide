package com.spravochnic.scbguide.root.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.spravochnic.scbguide.home.content.HomeContent
import com.spravochnic.scbguide.root.PreviewRootComponent
import com.spravochnic.scbguide.root.RootComponent
import com.spravochnic.scbguide.root.navigator.factory.ChildComponent
import com.spravochnic.scbguide.splash.content.SplashContent
import com.spravochnic.scbguide.uikit.theme.ScbGuiideTheme

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    ScbGuiideTheme {
        Children(
            component = component,
            modifier = modifier,
        )
    }
}

@OptIn(ExperimentalDecomposeApi::class)
@Composable
private fun Children(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = predictiveBackAnimation(
            backHandler = component.backHandler,
            fallbackAnimation = stackAnimation(fade() + scale()),
            onBack = component::pop,
        ),
    ) { children ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            when(val child = children.instance) {
                is ChildComponent.HomeChild -> HomeContent(
                    component = child.component,
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                )

                is ChildComponent.SplashChild -> SplashContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )

                else -> {

                }
            }
        }
    }
}

@Preview
@Composable
internal fun RootContentPreview() {
    RootContent(PreviewRootComponent())
}
