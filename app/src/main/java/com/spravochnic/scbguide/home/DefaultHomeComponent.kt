package com.spravochnic.scbguide.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.retainedInstance
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.home.delegate.DefaultHomeDelegate
import com.spravochnic.scbguide.home.delegate.HomeDelegate
import com.spravochnic.scbguide.home.navigator.HomeNavigator
import com.spravochnic.scbguide.uikit.request.component.DefaultRequestComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DefaultHomeComponent(
    resManager: ResManager,
    homeNavigator: HomeNavigator,
    componentContext: ComponentContext,
) : HomeComponent, ComponentContext by componentContext {

    private val componentScope by lazy { coroutineScope(Dispatchers.Main + SupervisorJob()) }

    override val stateValue: Value<HomeComponent.State> by lazy { homeDelegate.stateValue }

    override val initialState by lazy {
        stateKeeper.consume(
            key = RETAINED_SAVED_INSTANCE_HOME_DELEGATE,
            strategy = HomeComponent.State.serializer()
        ) ?: HomeComponent.State.Request(
            DefaultRequestComponent(componentContext = componentContext)
        )
    }

    private val homeDelegate: HomeDelegate =
        retainedInstance {
            DefaultHomeDelegate(
                initialState = initialState,
                scope = componentScope,
                homeNavigator = homeNavigator,
                resManager = resManager,
                componentContext = componentContext,
            )
        }


    private companion object {
        const val RETAINED_SAVED_INSTANCE_HOME_DELEGATE = "RETAINED_SAVED_INSTANCE_HOME_DELEGATE"
    }
}