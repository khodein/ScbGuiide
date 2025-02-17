package com.spravochnic.scbguide.root.db.status

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ScbDatabase_StatusTable")
data class StatusEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
)