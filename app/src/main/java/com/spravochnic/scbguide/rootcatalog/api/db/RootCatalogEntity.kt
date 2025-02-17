package com.spravochnic.scbguide.rootcatalog.api.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScbDatabase_RootCatalogTable")
data class RootCatalogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
)