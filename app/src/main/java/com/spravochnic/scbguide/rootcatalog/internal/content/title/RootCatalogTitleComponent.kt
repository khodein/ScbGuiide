package com.spravochnic.scbguide.rootcatalog.internal.content.title

import androidx.annotation.DrawableRes

interface RootCatalogTitleComponent {

    data class State(
        val title: String,
        val subTitle: SubTitle? = null,
    ) {
        data class SubTitle(
            val text: String,
            @DrawableRes val leadingRes: Int,
        )
    }
}