package com.spravochnic.scbguide.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.spravochnic.scbguide.catalogroot.api.db.RootCatalogDao
import com.spravochnic.scbguide.catalogroot.api.db.RootCatalogEntity
import com.spravochnic.scbguide.lectory.api.db.TopLectoryCatalogDao
import com.spravochnic.scbguide.lectory.api.db.TopLectoryCatalogEntity
import com.spravochnic.scbguide.quest.api.db.catalog.TopQuestCatalogDao
import com.spravochnic.scbguide.quest.api.db.catalog.TopQuestCatalogEntity
import com.spravochnic.scbguide.status.api.db.status.StatusDao
import com.spravochnic.scbguide.status.api.db.status.StatusEntity
import com.spravochnic.scbguide.utils.Constants

@Database(
    entities = [
        StatusEntity::class,
        RootCatalogEntity::class,
        TopLectoryCatalogEntity::class,
        TopQuestCatalogEntity::class,
    ], version = 1
)
abstract class ScbDatabase : RoomDatabase() {
    abstract fun statusDao(): StatusDao
    abstract fun rootCatalogDao(): RootCatalogDao
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
                    Constants.SCB_DATABASE,
                ).allowMainThreadQueries().build()
                INSTANCE = db
                db
            }
        }
    }
}