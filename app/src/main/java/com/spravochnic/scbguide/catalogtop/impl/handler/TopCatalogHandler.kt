package com.spravochnic.scbguide.catalogtop.impl.handler

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.catalogroot.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.catalogtop.api.component.TopCatalogComponent
import com.spravochnic.scbguide.catalogtop.impl.mapper.TopCatalogStateMapper
import com.spravochnic.scbguide.lectory.api.model.TopLectoryCatalogModel
import com.spravochnic.scbguide.lectory.api.repository.LectoryCatalogRepository
import com.spravochnic.scbguide.quest.api.model.TopQuestCatalogModel
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TopCatalogHandler(
    private val rootCatalogTypeModel: RootCatalogTypeModel,
    private val scope: CoroutineScope,
    private val rootRouter: RootRouter,
    private val topCatalogStateMapper: TopCatalogStateMapper,
    private val questCatalogRepository: QuestCatalogRepository,
    private val lectoryCatalogRepository: LectoryCatalogRepository,
    initialState: TopCatalogComponent.State,
) : InstanceKeeper.Instance {

    val toolbarValue: MutableValue<TopCatalogComponent.ToolbarChild> = MutableValue(
        if (rootCatalogTypeModel == RootCatalogTypeModel.LECTORY) {
            topCatalogStateMapper.mapToolbarCatalog(rootRouter::pop)
        } else {
            topCatalogStateMapper.mapToolbarQuestCatalog(rootRouter::pop)
        }
    )

    val stateValue: MutableValue<TopCatalogComponent.State> = MutableValue(initialState)

    init {
        loadData()
    }

    private fun loadData() {
        scope.launch {
            updateLoading()
            delay(1000)
            when (rootCatalogTypeModel) {
                RootCatalogTypeModel.LECTORY -> loadLectoryCatalog()
                RootCatalogTypeModel.QUEST -> loadQuestCatalog()
            }
        }
    }

    private suspend fun loadQuestCatalog() {
        runCatching {
            questCatalogRepository.getTopCatalog()
        }
            .onSuccess(::updateQuestCatalog)
            .onFailure(::updateFailure)
    }

    private suspend fun loadLectoryCatalog() {
        runCatching {
            lectoryCatalogRepository.getTopCatalog()
        }
            .onSuccess(::updateSuccessCatalog)
            .onFailure(::updateFailure)
    }

    private fun updateQuestCatalog(list: List<TopQuestCatalogModel>) {
        if (list.isEmpty()) {
            updateEmpty()
            return
        }

        updateSuccess(topCatalogStateMapper.mapQuestCatalog(list))
    }

    private fun updateSuccessCatalog(list: List<TopLectoryCatalogModel>) {
        if (list.isEmpty()) {
            updateEmpty()
            return
        }

        updateSuccess(topCatalogStateMapper.mapCatalog(list))
    }

    private fun updateLoading() {
        stateValue.value = TopCatalogComponent.State.Request(RequestComponent.State.Loading())
    }

    private fun updateSuccess(child: TopCatalogComponent.Child.NavItemChild) {
        stateValue.value = TopCatalogComponent.State.Success(child)
    }

    private fun updateEmpty() {
        stateValue.value = TopCatalogComponent.State.Request(
            RequestComponent.State.Empty(
                message = "Здесь пусто",
                buttonReloadMessage = "Обновить?",
                onReloadClick = ::loadData
            )
        )
    }

    private fun updateFailure(throwable: Throwable) {
        stateValue.value = TopCatalogComponent.State.Request(
            RequestComponent.State.Error(
                message = throwable.message ?: "Произошла ошибка загрузки",
                buttonReloadMessage = "Обновить?",
                onReloadClick = ::loadData
            )
        )
    }
}