package com.spravochnic.scbguide.root_api.config

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootConfig {

    @Serializable
    data class TopCatalog(val alias: String) : RootConfig

    @Serializable
    data object RootCatalog : RootConfig

    @Serializable
    data object Splash : RootConfig
}