package com.spravochnic.scbguide.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.spravochnic.scbguide.catalog.db.CatalogDao
import com.spravochnic.scbguide.catalog.db.CatalogEntity
import com.spravochnic.scbguide.root.db.status.StatusDao
import com.spravochnic.scbguide.root.db.status.StatusEntity
import com.spravochnic.scbguide.rootcatalog.db.RootCatalogDao
import com.spravochnic.scbguide.rootcatalog.db.RootCatalogEntity
import com.spravochnic.scbguide.utils.Constants

@Database(
    entities = [
        StatusEntity::class,
        RootCatalogEntity::class,
        CatalogEntity::class
    ], version = 1
)
abstract class ScbDatabase : RoomDatabase() {
    abstract fun statusDao(): StatusDao
    abstract fun rootCatalogDao(): RootCatalogDao
    abstract fun catalogDao(): CatalogDao

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