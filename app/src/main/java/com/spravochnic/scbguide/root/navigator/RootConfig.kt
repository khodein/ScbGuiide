package com.spravochnic.scbguide.root.navigator

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootConfig {

    @Serializable
    data object Test : RootConfig

    @Serializable
    data object Lectory : RootConfig

    @Serializable
    data object Home : RootConfig

    @Serializable
    data object Splash : RootConfig
}