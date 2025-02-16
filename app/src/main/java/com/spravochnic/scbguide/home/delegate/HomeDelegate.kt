package com.spravochnic.scbguide.home.delegate

import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.home.HomeComponent

interface HomeDelegate {
    val stateValue: Value<HomeComponent.State>
}