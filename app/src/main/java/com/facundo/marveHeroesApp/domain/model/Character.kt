package com.facundo.marveHeroesApp.domain.model

import com.facundo.marveHeroesApp.data.database.entities.CharacterEntity
import com.facundo.marveHeroesApp.data.model.heroes.Result

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String,
    val lastUpdate: String = ""
)

    fun CharacterEntity.toDomain() = Character(
        id = id,
        name = name,
        description = description,
        thumbnail = thumbnail
    )

    fun Result.toDomain() = Character(
        id = id,
        name = name,
        description = description,
        thumbnail = thumbnail.path+"."+ thumbnail.extension

    )


