package com.spravochnic.scbguide.main.root_impl.module

import android.content.Context
import com.arkivanov.decompose.ComponentContext
import com.spravochnic.scbguide.catalogroot.api.module.RootCatalogModule
import com.spravochnic.scbguide.catalogroot.impl.component.DefaultRootCatalogComponent
import com.spravochnic.scbguide.catalogroot.impl.module.RootCatalogModuleImpl
import com.spravochnic.scbguide.catalogroot.impl.navigator.RootCatalogRooterImpl
import com.spravochnic.scbguide.catalogtop.api.module.TopCatalogModule
import com.spravochnic.scbguide.catalogtop.impl.component.DefaultTopCatalogComponent
import com.spravochnic.scbguide.catalogtop.impl.module.TopCatalogModuleImpl
import com.spravochnic.scbguide.catalogtop.impl.router.TopCatalogRouterImpl
import com.spravochnic.scbguide.db.ScbDatabase
import com.spravochnic.scbguide.lectory.api.module.LectoryCatalogModule
import com.spravochnic.scbguide.lectory.impl.module.LectoryCatalogModuleImpl
import com.spravochnic.scbguide.main.root_impl.db.DaoModuleImpl
import com.spravochnic.scbguide.main.root_impl.router.RootRouterImpl
import com.spravochnic.scbguide.quest.api.module.QuestCatalogModule
import com.spravochnic.scbguide.quest.impl.module.QuestCatalogModuleImpl
import com.spravochnic.scbguide.root_api.config.RootConfig
import com.spravochnic.scbguide.root_api.router.RootRouter
import com.spravochnic.scbguide.splash.impl.component.DefaultSplashComponent
import com.spravochnic.scbguide.splash.impl.module.SplashModuleImpl
import com.spravochnic.scbguide.status.api.module.StatusModule
import com.spravochnic.scbguide.status.impl.module.StatusModuleImpl
import com.spravochnic.scbguide.utils.resmanager.ResManagerImpl

class MainModule(
    context: Context,
) {
    val rootRouter: RootRouter by lazy {
        RootRouterImpl(
            rootCatalogRooter = RootCatalogRooterImpl(),
            topCatalogRouter = TopCatalogRouterImpl()
        )
    }

    private val daoModule by lazy {
        DaoModuleImpl(ScbDatabase.getInstance(context))
    }

    private val rootModule = RootModuleImpl(
        rootRouter = rootRouter,
        resManager = ResManagerImpl(context)
    )

    private val rootCatalogModule: RootCatalogModule by lazy {
        RootCatalogModuleImpl(
            rootModule = rootModule,
            daoModule = daoModule
        )
    }

    private val statusModule: StatusModule by lazy {
        StatusModuleImpl(
            daoModule = daoModule,
            rootModule = rootModule,
        )
    }

    private val lectoryCatalogModule: LectoryCatalogModule by lazy {
        LectoryCatalogModuleImpl(
            daoModule = daoModule,
            rootModule = rootModule,
        )
    }
    private val questCatalogModule: QuestCatalogModule by lazy {
        QuestCatalogModuleImpl(
            daoModule = daoModule,
            rootModule = rootModule,
        )
    }

    private val topCatalogModule: TopCatalogModule by lazy {
        TopCatalogModuleImpl(
            rootModule = rootModule
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
                val mainModule = MainModule(context)
                INSTANCE = mainModule
                mainModule
            }
        }
    }
}