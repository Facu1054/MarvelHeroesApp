package com.facundo.marveHeroesApp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.facundo.marveHeroesApp.domain.model.AppSyncModel
import com.facundo.marveHeroesApp.domain.model.Character

@Entity(tableName = "appSync")
data class AppSyncEntity(
@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id") val id: Int = 0,
@ColumnInfo(name = "lastUpdate") val lastUpdate: String,
)

fun AppSyncModel.toDatabase() = AppSyncEntity(
    id = id,
    lastUpdate = lastUpdate
)
