package com.spravochnic.scbguide.home.delegate

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.home.HomeComponent
import com.spravochnic.scbguide.home.navigator.HomeNavigator
import com.spravochnic.scbguide.home.title.DefaultHomeTitleComponent
import com.spravochnic.scbguide.home.title.HomeTitleComponent
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent
import com.spravochnic.scbguide.uikit.notice.component.DefaultNoticeItemComponent
import com.spravochnic.scbguide.uikit.notice.component.NoticeItemComponent
import com.spravochnic.scbguide.uikit.request.component.DefaultRequestComponent
import com.spravochnic.scbguide.uikit.request.component.RequestComponent
import com.spravochnic.scbguide.uikit.theme.color.Note
import com.spravochnic.scbguide.utils.resmanager.ResManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DefaultHomeDelegate(
    private val homeNavigator: HomeNavigator,
    private val componentContext: ComponentContext,
    private val scope: CoroutineScope,
    private val resManager: ResManager,
    initialState: HomeComponent.State,
) : InstanceKeeper.Instance, HomeDelegate {

    override val stateValue: MutableValue<HomeComponent.State> = MutableValue(initialState)

    private val titleHomeComponent: HomeTitleComponent by lazy {
        DefaultHomeTitleComponent(
            componentContext = componentContext,
            initialState = HomeTitleComponent.State(
                title = resManager.getString(R.string.default_home_title_text),
            )
        )
    }

    private val noticeItemComponent by lazy {
        DefaultNoticeItemComponent(
            componentContext = componentContext,
            initialState = NoticeItemComponent.State(
                title = resManager.getString(R.string.default_home_notice_title_text),
                description = resManager.getString(R.string.default_home_notice_description_text)
            )
        )
    }

    private val requestComponent: RequestComponent by lazy {
        DefaultRequestComponent(componentContext = componentContext)
    }

    init {
        reload()
    }

    private fun updateLoading() {
        stateValue.value = HomeComponent.State.Request(requestComponent)
        requestComponent.update(RequestComponent.State.Loading())
    }

    private fun updateSuccess(items: List<HomeComponent.Child>) {
        stateValue.value = HomeComponent.State.Request(requestComponent)
        requestComponent.update(RequestComponent.State.Success)
        stateValue.value = HomeComponent.State.Success(items)
    }

    private fun updateError() {
        stateValue.value = HomeComponent.State.Request(requestComponent)
        requestComponent.update(
            RequestComponent.State.Error(
                message = "Произошла ошибка загрузки",
                buttonReloadMessage = "Обновить?",
                onReloadClick = ::loadData
            )
        )
    }

    private fun loadData() {
        scope.launch {
            updateLoading()
            runCatching {
                withContext(Dispatchers.IO) {
                    delay(1000)
                    listOf(
                        NavItemComponent.State(
                            id = "",
                            text = "Лекторий",
                            subText = "3 уровня",
                            leading = NavItemComponent.State.Leading(
                                res = R.drawable.ic_splash,
                                tint = Note
                            ),
                            trailing = NavItemComponent.State.Trailing.Arrow(),
                            onClick = ::onClick
                        ),
                        NavItemComponent.State(
                            id = "",
                            text = "Испытания",
                            subText = "3 уровня",
                            leading = NavItemComponent.State.Leading(
                                res = R.drawable.ic_splash,
                                tint = Note
                            ),
                            trailing = NavItemComponent.State.Trailing.Arrow(),
                            onClick = ::onClick
                        ),
                    )
                    throw Throwable()
                }
            }.onSuccess { list ->
//                val items = buildList<HomeComponent.Child>(10) {
//                    add(HomeComponent.Child.TitleChild(titleHomeComponent))
//                    add(HomeComponent.Child.NoticeChild(noticeItemComponent))
//                    list.forEach {
//                        add(
//                            HomeComponent.Child.NavItemChild(
//                                DefaultNavItemComponent(
//                                    initialState = it,
//                                    componentContext = componentContext
//                                )
//                            )
//                        )
//                    }
//                }
//
//                updateSuccess()
//                stateValue.value = HomeComponent.State.Success(items)
            }.onFailure {
                updateError()
            }
        }
    }

    private fun reload() {
        loadData()
    }

    override fun onDestroy() {
        scope.cancel()
    }

    private fun onClick(state: NavItemComponent.State) {

    }
}