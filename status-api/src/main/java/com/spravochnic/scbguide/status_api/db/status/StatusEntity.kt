package com.spravochnic.scbguide.status_api.db.status

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScbDatabase_StatusTable")
data class StatusEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
)