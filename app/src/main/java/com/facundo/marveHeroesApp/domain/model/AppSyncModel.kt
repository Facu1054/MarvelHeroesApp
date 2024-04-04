package com.facundo.marveHeroesApp.domain.model

import com.facundo.marveHeroesApp.data.database.entities.AppSyncEntity
import com.facundo.marveHeroesApp.data.database.entities.CharacterEntity

data class AppSyncModel (
    val id: Int,
    val lastUpdate: String
)

fun AppSyncEntity.toDomain() = AppSyncModel(
    id = id,
    lastUpdate = lastUpdate
)