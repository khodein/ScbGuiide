package com.spravochnic.scbguide.rootcatalog.component.title

import androidx.annotation.DrawableRes
import com.arkivanov.decompose.value.Value

interface RootCatalogTitleComponent {
    val stateValue: Value<State>

    fun update(state: State)

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