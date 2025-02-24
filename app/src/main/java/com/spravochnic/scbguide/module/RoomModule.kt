package com.spravochnic.scbguide.module

import androidx.room.Room
import com.spravochnic.scbguide.catalog_root_api.db.RootCatalogDao
import com.spravochnic.scbguide.lectory_api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.quest_api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.root_impl.db.ScbDatabase
import com.spravochnic.scbguide.status_api.db.status.StatusDao
import com.spravochnic.scbguide.utils.Constants
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            get(),
            ScbDatabase::class.java,
            Constants.SCB_DATABASE,
        ).allowMainThreadQueries().build()
    }

    single<StatusDao> { get<ScbDatabase>().statusDao() }

    single<TopQuestCatalogDao> { get<ScbDatabase>().topQuestCatalogDao() }

    single<TopLectoryCatalogDao> { get<ScbDatabase>().topLectoryCatalogDao() }

    single<RootCatalogDao> { get<ScbDatabase>().rootCatalogDao() }
}