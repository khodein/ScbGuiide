package com.spravochnic.scbguide.lectory.api.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScbDatabase_TopLectoryCatalogTable")
data class TopLectoryCatalogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)