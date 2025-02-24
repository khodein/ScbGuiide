package com.spravochnic.scbguide.root_impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spravochnic.scbguide.catalog_root_api.db.RootCatalogDao
import com.spravochnic.scbguide.catalog_root_api.db.RootCatalogEntity
import com.spravochnic.scbguide.lectory_api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.lectory_api.db.TopLectoryCatalogEntity
import com.spravochnic.scbguide.quest_api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.quest_api.db.catalog.TopQuestCatalogEntity
import com.spravochnic.scbguide.status_api.db.status.StatusDao
import com.spravochnic.scbguide.status_api.db.status.StatusEntity

@Database(
    entities = [
        StatusEntity::class,
        RootCatalogEntity::class,
        TopLectoryCatalogEntity::class,
        TopQuestCatalogEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class ScbDatabase : RoomDatabase() {
    abstract fun statusDao(): StatusDao
    abstract fun rootCatalogDao(): RootCatalogDao
    abstract fun topLectoryCatalogDao(): TopLectoryCatalogDao
    abstract fun topQuestCatalogDao(): TopQuestCatalogDao
}