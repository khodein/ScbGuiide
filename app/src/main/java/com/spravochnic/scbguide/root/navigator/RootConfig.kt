package com.spravochnic.scbguide.root.navigator

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootConfig {

    @Serializable
    data object Catalog : RootConfig

    @Serializable
    data object RootCatalog : RootConfig

    @Serializable
    data object Splash : RootConfig
}