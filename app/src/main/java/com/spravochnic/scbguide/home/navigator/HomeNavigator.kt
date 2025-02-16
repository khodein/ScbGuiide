package com.spravochnic.scbguide.home.navigator

import com.spravochnic.scbguide.root.navigator.RootNavigator

interface HomeNavigator {
    fun init(parent: RootNavigator)
    fun replaceToHome()
    fun gotoLectory()
    fun gotoTest()
}