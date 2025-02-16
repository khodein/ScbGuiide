package com.spravochnic.scbguide.home.title

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewHomeTitleComponent : HomeTitleComponent, ComponentContext by PreviewComponentContext {

    override val stateValue: Value<HomeTitleComponent.State> = MutableValue(
        HomeTitleComponent.State(
            title = "Title",
            subTitle = HomeTitleComponent.State.SubTitle(
                text = "Subtitle",
                leadingRes = R.drawable.ic_award
            )
        )
    )

    override fun update(state: HomeTitleComponent.State) = Unit
}