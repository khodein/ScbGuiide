package com.spravochnic.scbguide.catalog.internal.handler

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.spravochnic.scbguide.catalog.api.component.CatalogComponent
import com.spravochnic.scbguide.catalog.api.model.CatalogModel
import com.spravochnic.scbguide.catalog.api.repository.CatalogRepository
import com.spravochnic.scbguide.catalog.internal.mapper.CatalogStateMapper
import com.spravochnic.scbguide.quest.api.model.QuestCatalogModel
import com.spravochnic.scbguide.quest.api.repostiory.QuestCatalogRepository
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.rootcatalog.api.model.RootCatalogTypeModel
import com.spravochnic.scbguide.uikit.request.RequestComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CatalogHandler(
    private val rootCatalogTypeModel: RootCatalogTypeModel,
    private val scope: CoroutineScope,
    private val rootNavigator: RootNavigator,
    private val catalogStateMapper: CatalogStateMapper,
    private val questCatalogRepository: QuestCatalogRepository,
    private val catalogRepository: CatalogRepository,
    initialState: CatalogComponent.State,
) : InstanceKeeper.Instance {

    val toolbarValue: MutableValue<CatalogComponent.ToolbarChild> = MutableValue(
        if (rootCatalogTypeModel == RootCatalogTypeModel.LECTORY) {
            catalogStateMapper.mapToolbarCatalog(rootNavigator::pop)
        } else {
            catalogStateMapper.mapToolbarQuestCatalog(rootNavigator::pop)
        }
    )

    val stateValue: MutableValue<CatalogComponent.State> = MutableValue(initialState)

    init {
        loadData()
    }

    private fun loadData() {
        scope.launch {
            updateLoading()
            delay(1000)
            when (rootCatalogTypeModel) {
                RootCatalogTypeModel.LECTORY -> loadCatalog()
                RootCatalogTypeModel.QUEST -> loadQuestCatalog()
            }
        }
    }

    private suspend fun loadQuestCatalog() {
        runCatching {
            questCatalogRepository.getQuestCatalog()
        }
            .onSuccess(::updateQuestCatalog)
            .onFailure(::updateFailure)
    }

    private suspend fun loadCatalog() {
        runCatching {
            catalogRepository.getCatalog()
        }
            .onSuccess(::updateSuccessCatalog)
            .onFailure(::updateFailure)
    }

    private fun updateQuestCatalog(list: List<QuestCatalogModel>) {
        updateSuccess(catalogStateMapper.mapQuestCatalog(list))
    }

    private fun updateSuccessCatalog(list: List<CatalogModel>) {
        updateSuccess(catalogStateMapper.mapCatalog(list))
    }

    private fun updateLoading() {
        stateValue.value = CatalogComponent.State.Request(RequestComponent.State.Loading())
    }

    private fun updateSuccess(child: CatalogComponent.Child.NavItemChild) {
        stateValue.value = CatalogComponent.State.Success(child)
    }

    private fun updateFailure(throwable: Throwable) {
        stateValue.value = CatalogComponent.State.Request(
            RequestComponent.State.Error(
                message = throwable.message ?: "Произошла ошибка загрузки",
                onReloadClick = ::loadData
            )
        )
    }
}