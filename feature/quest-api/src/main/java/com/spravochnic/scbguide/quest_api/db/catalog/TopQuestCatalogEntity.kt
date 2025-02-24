package com.spravochnic.scbguide.quest_api.db.catalog

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScbDatabase_TopQuestCatalogTable")
data class TopQuestCatalogEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)