package com.spravochnic.scbguide.root_impl.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.catalog_root_impl.component.DefaultRootCatalogComponent
import com.spravochnic.scbguide.catalog_top_impl.component.DefaultTopCatalogComponent
import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.splash_impl.component.DefaultSplashComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext, KoinComponent {

    private val router by inject<RootRouter>()
    private val stackNavigator = StackNavigation<RootConfig>()

    init {
        router.init(stackNavigator)
    }

    private val _stack =
        childStack(
            source = stackNavigator,
            serializer = RootConfig.serializer(),
            initialStack = ::getInitialStack,
            childFactory = ::getChild,
        )

    override val stack: Value<ChildStack<*, RootComponent.ChildComponent>> = _stack

    private fun getChild(
        config: RootConfig,
        componentContext: ComponentContext,
    ): RootComponent.ChildComponent {
        return when (config) {
            is RootConfig.RootCatalog -> {
                RootComponent.ChildComponent.RootCatalogChild(
                    DefaultRootCatalogComponent(
                        componentContext = componentContext,
                    )
                )
            }

            is RootConfig.Splash -> RootComponent.ChildComponent.SplashChild(
                DefaultSplashComponent(
                    componentContext = componentContext,
                )
            )

            is RootConfig.TopCatalog -> RootComponent.ChildComponent.TopCatalogChild(
                DefaultTopCatalogComponent(
                    componentContext = componentContext,
                    rootCatalogAlias = config.alias,
                )
            )
        }
    }

    override fun pop() {
        router.pop()
    }

    private fun getInitialStack(): List<RootConfig> {
        return listOf(RootConfig.Splash)
    }
}