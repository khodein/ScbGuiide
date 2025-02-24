package com.spravochnic.scbguide

import android.app.Application
import com.spravochnic.scbguide.catalog_root_impl.module.rootCatalogModule
import com.spravochnic.scbguide.catalog_top_impl.module.topCatalogModule
import com.spravochnic.scbguide.lectory_impl.module.lectoryModule
import com.spravochnic.scbguide.module.appModule
import com.spravochnic.scbguide.module.roomModule
import com.spravochnic.scbguide.module.routerModule
import com.spravochnic.scbguide.quest_impl.module.questModule
import com.spravochnic.scbguide.status_impl.module.statusModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                appModule,
                roomModule,
                routerModule,
                rootCatalogModule,
                topCatalogModule,
                questModule,
                lectoryModule,
                statusModule,
            )
        }
    }
}