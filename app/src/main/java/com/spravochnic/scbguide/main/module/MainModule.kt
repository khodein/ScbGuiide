package com.spravochnic.scbguide.main.module

import android.content.Context
import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalog_root_api.module.RootCatalogModule
import com.spravochnic.scbguide.catalog_root_impl.component.DefaultRootCatalogComponent
import com.spravochnic.scbguide.catalog_root_impl.module.RootCatalogModuleImpl
import com.spravochnic.scbguide.catalog_root_impl.navigator.RootCatalogRooterImpl
import com.spravochnic.scbguide.catalog_top_api.module.TopCatalogModule
import com.spravochnic.scbguide.catalog_top_impl.component.DefaultTopCatalogComponent
import com.spravochnic.scbguide.catalog_top_impl.module.TopCatalogModuleImpl
import com.spravochnic.scbguide.catalog_top_impl.router.TopCatalogRouterImpl
import com.spravochnic.scbguide.lectory_api.module.LectoryCatalogModule
import com.spravochnic.scbguide.lectory_impl.module.LectoryCatalogModuleImpl
import com.spravochnic.scbguide.quest_api.module.QuestCatalogModule
import com.spravochnic.scbguide.quest_impl.module.QuestCatalogModuleImpl
import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.root_api.utils.ResManager
import com.spravochnic.scbguide.root_impl.db.ScbDatabase
import com.spravochnic.scbguide.root_impl.module.RootModuleImpl
import com.spravochnic.scbguide.root_impl.router.RootRouterImpl
import com.spravochnic.scbguide.root_impl.utils.resmanager.ResManagerImpl
import com.spravochnic.scbguide.splash_impl.component.DefaultSplashComponent
import com.spravochnic.scbguide.splash_impl.module.SplashModuleImpl
import com.spravochnic.scbguide.status_api.module.StatusModule
import com.spravochnic.scbguide.status_impl.module.StatusModuleImpl

class MainModule(
    private val db: ScbDatabase,
    resManager: ResManager,
) {
    val rootRouter: RootRouter by lazy {
        RootRouterImpl(
            rootCatalogRooter = RootCatalogRooterImpl(),
            topCatalogRouter = TopCatalogRouterImpl()
        )
    }

    private val rootModule = RootModuleImpl(
        rootRouter = rootRouter,
        resManager = resManager
    )

    private val rootCatalogModule: RootCatalogModule by lazy {
        RootCatalogModuleImpl(
            rootModule = rootModule,
            rootCatalogDao = db.rootCatalogDao()
        )
    }

    private val lectoryCatalogModule: LectoryCatalogModule by lazy {
        LectoryCatalogModuleImpl(
            topLectoryCatalogDao = db.topLectoryCatalogDao(),
            rootModule = rootModule,
        )
    }
    private val questCatalogModule: QuestCatalogModule by lazy {
        QuestCatalogModuleImpl(
            topQuestCatalogDao = db.topQuestCatalogDao(),
            rootModule = rootModule,
        )
    }

    private val topCatalogModule: TopCatalogModule by lazy {
        TopCatalogModuleImpl(
            rootModule = rootModule
        )
    }

    private val statusModule: StatusModule by lazy {
        StatusModuleImpl(
            statusDao = db.statusDao(),
            rootModule = rootModule,
            questCatalogModule = questCatalogModule,
            lectoryCatalogModule = lectoryCatalogModule,
            rootCatalogModule = rootCatalogModule,
        )
    }

    fun get(
        config: RootConfig,
        componentContext: ComponentContext,
    ): ChildComponent {
        return when (config) {
            is RootConfig.RootCatalog -> {
                ChildComponent.RootCatalogChild(
                    DefaultRootCatalogComponent(
                        statusModule = statusModule,
                        rootCatalogModule = rootCatalogModule,
                        componentContext = componentContext,
                    )
                )
            }

            is RootConfig.Splash -> ChildComponent.SplashChild(
                DefaultSplashComponent(
                    componentContext = componentContext,
                    splashModule = SplashModuleImpl(rootModule)
                )
            )

            is RootConfig.TopCatalog -> ChildComponent.TopCatalogChild(
                DefaultTopCatalogComponent(
                    componentContext = componentContext,
                    rootCatalogAlias = config.alias,
                    topCatalogModule = topCatalogModule,
                    lectoryCatalogModule = lectoryCatalogModule,
                    questCatalogModule = questCatalogModule
                )
            )
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: MainModule? = null

        fun getInstance(
            context: Context,
        ): MainModule {
            return INSTANCE ?: synchronized(this) {
                val mainModule = MainModule(
                    resManager = ResManagerImpl(context),
                    db = ScbDatabase.getInstance(context)
                )
                INSTANCE = mainModule
                mainModule
            }
        }
    }
}