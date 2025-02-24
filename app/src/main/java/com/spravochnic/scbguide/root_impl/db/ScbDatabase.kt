package com.spravochnic.scbguide.root_impl.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.spravochnic.scbguide.lectory_api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.lectory_api.db.TopLectoryCatalogEntity
import com.spravochnic.scbguide.quest_api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.quest_api.db.catalog.TopQuestCatalogEntity
import com.spravochnic.scbguide.status_api.db.status.StatusDao
import com.spravochnic.scbguide.status_api.db.status.StatusEntity

@Database(
    entities = [
        StatusEntity::class,
        com.spravochnic.scbguide.catalog_root_api.db.RootCatalogEntity::class,
        TopLectoryCatalogEntity::class,
        TopQuestCatalogEntity::class,
    ], version = 1
)
abstract class ScbDatabase : RoomDatabase() {
    abstract fun statusDao(): StatusDao
    abstract fun rootCatalogDao(): com.spravochnic.scbguide.catalog_root_api.db.RootCatalogDao
    abstract fun topLectoryCatalogDao(): TopLectoryCatalogDao
    abstract fun topQuestCatalogDao(): TopQuestCatalogDao

    companion object {
        @Volatile
        private var INSTANCE: ScbDatabase? = null

        fun getInstance(context: Context): ScbDatabase {
            return INSTANCE ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context,
                    ScbDatabase::class.java,
                    com.spravochnic.scbguide.utils.Constants.SCB_DATABASE,
                ).allowMainThreadQueries().build()
                INSTANCE = db
                db
            }
        }
    }
}