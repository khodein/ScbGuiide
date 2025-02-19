package com.spravochnic.scbguide.quest.api.db.catalog

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScbDatabase_QuestCatalogTable")
data class QuestCatalogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)