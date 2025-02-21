package com.spravochnic.scbguide.main.root_impl.content

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
import com.spravochnic.scbguide.catalogroot.impl.content.RootCatalogContent
import com.spravochnic.scbguide.catalogtop.impl.content.CatalogContent
import com.spravochnic.scbguide.main.root_impl.component.RootComponent
import com.spravochnic.scbguide.main.root_impl.module.ChildComponent
import com.spravochnic.scbguide.main.root_impl.preview.PreviewRootComponent
import com.spravochnic.scbguide.splash.impl.content.SplashContent
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
            when (val child = children.instance) {
                is ChildComponent.RootCatalogChild -> RootCatalogContent(
                    component = child.component,
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                )

                is ChildComponent.SplashChild -> SplashContent(
                    component = child.component,
                    modifier = Modifier.fillMaxSize()
                )

                is ChildComponent.TopCatalogChild -> CatalogContent(
                    component = child.component,
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                )
            }
        }
    }
}

@Preview
@Composable
internal fun RootContentPreview() {
    RootContent(PreviewRootComponent())
}
