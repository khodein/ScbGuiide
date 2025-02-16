package com.spravochnic.scbguide.root.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.spravochnic.scbguide.home.navigator.HomeNavigator

interface RootNavigator :
    HomeNavigator {

    fun init(stackNavigation: StackNavigation<RootConfig>)

    fun pushNew(config: RootConfig)
    fun replaceCurrent(config: RootConfig)

    fun pop()
    fun pop(toIndex: Int)
}