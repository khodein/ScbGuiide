package com.spravochnic.scbguide.uikit.notice.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class DefaultNoticeItemComponent(
    state: NoticeItemComponent.State,
    componentContext: ComponentContext,
) : NoticeItemComponent, ComponentContext by componentContext {

    private val _stateValue = MutableValue(state)
    override val stateValue: Value<NoticeItemComponent.State> = _stateValue
}