package com.spravochnic.scbguide.rootcatalog.delegate

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.R
import com.spravochnic.scbguide.root.navigator.RootNavigator
import com.spravochnic.scbguide.root.repository.RootRepository
import com.spravochnic.scbguide.rootcatalog.component.RootCatalogComponent
import com.spravochnic.scbguide.rootcatalog.component.title.DefaultRootCatalogTitleComponent
import com.spravochnic.scbguide.rootcatalog.component.title.RootCatalogTitleComponent
import com.spravochnic.scbguide.rootcatalog.mapper.RootCatalogComponentMapper
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogListModel
import com.spravochnic.scbguide.rootcatalog.model.RootCatalogModel
import com.spravochnic.scbguide.rootcatalog.repository.RootCatalogRepository
import com.spravochnic.scbguide.uikit.navitem.component.DefaultNavItemComponent
import com.spravochnic.scbguide.uikit.navitem.component.NavItemComponent
import com.spravochnic.scbguide.uikit.notice.component.DefaultNoticeItemComponent
import com.spravochnic.scbguide.uikit.notice.component.NoticeItemComponent
import com.spravochnic.scbguide.uikit.request.component.DefaultRequestComponent
import com.spravochnic.scbguide.uikit.request.component.RequestComponent
import com.spravochnic.scbguide.utils.resmanager.ResManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DefaultRootCatalogDelegate(
    private val rootNavigator: RootNavigator,
    private val rootCatalogComponentMapper: RootCatalogComponentMapper,
    private val rootRepository: RootRepository,
    private val rootCatalogRepository: RootCatalogRepository,
    private val componentContext: ComponentContext,
    private val scope: CoroutineScope,
    private val resManager: ResManager,
    initialState: RootCatalogComponent.State,
) : InstanceKeeper.Instance {

    val stateValue: MutableValue<RootCatalogComponent.State> = MutableValue(initialState)

    private val titleRootCatalogComponent: RootCatalogTitleComponent by lazy {
        DefaultRootCatalogTitleComponent(
            componentContext = componentContext,
            initialState = RootCatalogTitleComponent.State(
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
        stateValue.value = RootCatalogComponent.State.Request(requestComponent)
        requestComponent.update(RequestComponent.State.Loading())
    }

    private fun updateSuccess(rootCatalogListModel: RootCatalogListModel) {
        updateTitleRootCatalogComponent(rootCatalogListModel)
        val items = buildList(10) {
            add(RootCatalogComponent.Child.TitleChild(titleRootCatalogComponent))
            add(RootCatalogComponent.Child.NoticeChild(noticeItemComponent))
            addAll(getNavItemComponents(rootCatalogListModel))
        }
        stateValue.value = RootCatalogComponent.State.Request(requestComponent)
        requestComponent.update(RequestComponent.State.Success)
        stateValue.value = RootCatalogComponent.State.Success(items)
    }

    private fun updateError(throwable: Throwable) {
        stateValue.value = RootCatalogComponent.State.Request(requestComponent)
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

                    async { rootRepository.validateStatus() }.await()

                    rootCatalogRepository.getRootCatalog()
                }
            }
                .onSuccess(::updateSuccess)
                .onFailure(::updateError)
        }
    }

    private fun getNavItemComponents(rootCatalogListModel: RootCatalogListModel): List<RootCatalogComponent.Child.NavItemChild> {
        return rootCatalogComponentMapper.map(
            list = rootCatalogListModel.list,
            onClick = ::onClick
        ).map { initState ->
            RootCatalogComponent.Child.NavItemChild(
                DefaultNavItemComponent(
                    initialState = initState,
                    componentContext = componentContext,
                ),
            )
        }
    }

    private fun updateTitleRootCatalogComponent(rootCatalogListModel: RootCatalogListModel) {
        if (rootCatalogListModel.count.isNotEmpty()) {
            titleRootCatalogComponent.update(
                titleRootCatalogComponent.stateValue.value.copy(
                    subTitle = RootCatalogTitleComponent.State.SubTitle(
                        text = rootCatalogListModel.count,
                        leadingRes = R.drawable.ic_award
                    )
                )
            )
        }
    }

    private fun reload() {
        loadData()
    }

    override fun onDestroy() {
        scope.cancel()
    }

    private fun onClick(state: NavItemComponent.State) {
        val data = state.data
        if (data != null && data is RootCatalogModel) {
            rootNavigator.gotoCatalog(alias = data.alias)
        }
    }
}