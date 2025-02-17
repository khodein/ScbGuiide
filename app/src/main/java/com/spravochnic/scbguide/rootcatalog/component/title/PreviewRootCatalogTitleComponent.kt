package com.spravochnic.scbguide.rootcatalog.component.title

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewRootCatalogTitleComponent : RootCatalogTitleComponent,
    ComponentContext by PreviewComponentContext {

    override val stateValue: Value<RootCatalogTitleComponent.State> = MutableValue(
        RootCatalogTitleComponent.State(
            title = "Title",
            subTitle = RootCatalogTitleComponent.State.SubTitle(
                text = "Subtitle",
                leadingRes = R.drawable.ic_award
            )
        )
    )

    override fun update(state: RootCatalogTitleComponent.State) = Unit
}