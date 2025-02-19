package com.spravochnic.scbguide.main

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.core.view.WindowInsetsControllerCompat
import com.arkivanov.decompose.defaultComponentContext
import com.spravochnic.scbguide.catalog.api.db.CatalogDao
import com.spravochnic.scbguide.catalog.api.factory.CatalogFactory
import com.spravochnic.scbguide.catalog.api.navigator.CatalogNavigator
import com.spravochnic.scbguide.catalog.internal.factory.CatalogFactoryImpl
import com.spravochnic.scbguide.catalog.internal.navigator.CatalogNavigatorImpl
import com.spravochnic.scbguide.catalog.internal.repository.CatalogRepositoryImpl
import com.spravochnic.scbguide.db.ScbDatabase
import com.spravochnic.scbguide.quest.api.db.catalog.QuestCatalogDao
import com.spravochnic.scbguide.quest.internal.repository.QuestCatalogRepositoryImpl
import com.spravochnic.scbguide.root.api.config.RootNavigator
import com.spravochnic.scbguide.root.api.db.status.StatusDao
import com.spravochnic.scbguide.root.internal.builder.RootComponentBuilder
import com.spravochnic.scbguide.root.internal.component.DefaultRootComponent
import com.spravochnic.scbguide.root.internal.content.RootContent
import com.spravochnic.scbguide.root.internal.navigator.RootNavigatorImpl
import com.spravochnic.scbguide.rootcatalog.api.db.RootCatalogDao
import com.spravochnic.scbguide.rootcatalog.api.factory.RootCatalogFactory
import com.spravochnic.scbguide.rootcatalog.api.navigator.RootCatalogNavigator
import com.spravochnic.scbguide.rootcatalog.internal.factory.RootCatalogFactoryImpl
import com.spravochnic.scbguide.rootcatalog.internal.navigator.RootCatalogNavigatorImpl
import com.spravochnic.scbguide.splash.api.factory.SplashFactory
import com.spravochnic.scbguide.splash.internal.factory.SplashFactoryImpl
import com.spravochnic.scbguide.uikit.theme.ScbGuiideTheme
import com.spravochnic.scbguide.utils.resmanager.ResManager
import com.spravochnic.scbguide.utils.resmanager.ResManagerImpl


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))

        val resManager: ResManager = ResManagerImpl(context = this)

        val rootCatalogNavigator: RootCatalogNavigator = RootCatalogNavigatorImpl()
        val catalogNavigator: CatalogNavigator = CatalogNavigatorImpl()

        val rootNavigator: RootNavigator = RootNavigatorImpl(
            rootCatalogNavigator = rootCatalogNavigator,
            catalogNavigator = catalogNavigator
        )

        val rootComponentBuilder = getBuilder(
            rootNavigator = rootNavigator,
            resManager = resManager,
        )

        val rootComponent =
            DefaultRootComponent(
                rootNavigator = rootNavigator,
                rootComponentBuilder = rootComponentBuilder,
                componentContext = defaultComponentContext(),
            )

        setContent {
            SideEffect {
                setNavAndStatusBar()
            }

            ScbGuiideTheme {
                RootContent(
                    component = rootComponent,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    private fun setNavAndStatusBar() {
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> {
                window.navigationBarColor = Color.BLACK
                window.statusBarColor = Color.TRANSPARENT
                WindowInsetsControllerCompat(window, window.decorView).apply {
                    isAppearanceLightStatusBars = true
                    isAppearanceLightNavigationBars = false
                }
            }

            Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1 -> {
                var flags = window.decorView.systemUiVisibility
                window.navigationBarColor = Color.BLACK
                window.statusBarColor = Color.TRANSPARENT
                flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.decorView.systemUiVisibility = flags
            }

            else -> {
                window.navigationBarColor = Color.BLACK
                window.statusBarColor = Color.TRANSPARENT
            }
        }
    }

    private fun getBuilder(
        rootNavigator: RootNavigator,
        resManager: ResManager,
    ): RootComponentBuilder {

        val db = ScbDatabase.getInstance(this)
        val statusDao = db.statusDao()
        val catalogDao = db.catalogDao()
        val rootCatalogDao = db.rootCatalogDao()
        val questCatalogDao = db.questCatalogDao()

        val splashFactory = getSplashFactory(
            rootNavigator = rootNavigator
        )

        val rootCatalogFactory = getRootCatalogFactory(
            rootNavigator = rootNavigator,
            resManager = resManager,
            statusDao = statusDao,
            catalogDao = catalogDao,
            rootCatalogDao = rootCatalogDao,
        )

        val catalogFactory = getCatalogFactory(
            resManager = resManager,
            rootNavigator = rootNavigator,
            catalogDao = catalogDao,
            questCatalogDao = questCatalogDao,
        )


        return RootComponentBuilder(
            rootCatalogFactory = rootCatalogFactory,
            catalogFactory = catalogFactory,
            splashFactory = splashFactory,
        )
    }

    private fun getRootCatalogFactory(
        statusDao: StatusDao,
        catalogDao: CatalogDao,
        rootNavigator: RootNavigator,
        rootCatalogDao: RootCatalogDao,
        resManager: ResManager,
    ): RootCatalogFactory {
        val factory: RootCatalogFactory = RootCatalogFactoryImpl(
            statusDao = statusDao,
            catalogDao = catalogDao,
            rootNavigator = rootNavigator,
            rootCatalogDao = rootCatalogDao,
            resManager = resManager
        )
        return factory
    }

    private fun getCatalogFactory(
        resManager: ResManager,
        rootNavigator: RootNavigator,
        catalogDao: CatalogDao,
        questCatalogDao: QuestCatalogDao,
    ): CatalogFactory {
        val factory: CatalogFactory = CatalogFactoryImpl(
            resManager = resManager,
            rootNavigator = rootNavigator,
            catalogRepository = CatalogRepositoryImpl(
                catalogDao = catalogDao
            ),
            questCatalogRepository = QuestCatalogRepositoryImpl(
                questCatalogDao = questCatalogDao,
            )
        )

        return factory
    }

    private fun getSplashFactory(
        rootNavigator: RootNavigator
    ): SplashFactory {
        val splashFactory: SplashFactory = SplashFactoryImpl(
            rootNavigator = rootNavigator,
        )

        return splashFactory
    }
}