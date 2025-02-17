package com.spravochnic.scbguide.catalog.api.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScbDatabase_CatalogTable")
data class CatalogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)