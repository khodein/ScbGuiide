package com.spravochnic.scbguide.component.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.spravochnic.scbguide.uikit.notice.component.DefaultNoticeItemComponent
import com.spravochnic.scbguide.uikit.notice.component.NoticeItemComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.component.home.title.DefaultHomeTitleComponent
import com.spravochnic.scbguide.component.home.title.HomeTitleComponent
import com.spravochnic.scbguide.navigate.HomeProvider
import com.spravochnic.scbguide.utils.ResManager
import kotlinx.coroutines.withContext

class DefaultHomeComponent(
    private val resManager: ResManager,
    private val provider: HomeProvider,
    componentContext: ComponentContext,
) : HomeComponent, ComponentContext by componentContext {

    private val componentScope by lazy { coroutineScope(Dispatchers.Main + SupervisorJob()) }

    override val titleHomeComponent: HomeTitleComponent by lazy {
        DefaultHomeTitleComponent(
            componentContext = componentContext,
            state = HomeTitleComponent.State(
                title = resManager.getString(R.string.default_home_title_text),
            )
        )
    }

    override val noticeItemComponent by lazy {
        DefaultNoticeItemComponent(
            componentContext = componentContext,
            state = NoticeItemComponent.State(
                title = resManager.getString(R.string.default_home_notice_title_text),
                description = resManager.getString(R.string.default_home_notice_description_text)
            )
        )
    }

    private val _stateValue = MutableValue(HomeComponent.State.Loading)
    override val stateValue: Value<HomeComponent.State> = _stateValue

    init {
        loadData()
    }

    private fun loadData() {
        _stateValue.value = HomeComponent.State.Loading

        componentScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {

                }
            }.onSuccess {

            }.onFailure {

            }
        }
    }

    override fun onClickLectory() {
        provider.gotoLectory()
    }

    override fun onClickTest() {
        provider.gotoTest()
    }
}