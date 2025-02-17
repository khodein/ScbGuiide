package com.spravochnic.scbguide.root.api.config

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootConfig {

    @Serializable
    data class Catalog(val alias: String) : RootConfig

    @Serializable
    data object RootCatalog : RootConfig

    @Serializable
    data object Splash : RootConfig
}