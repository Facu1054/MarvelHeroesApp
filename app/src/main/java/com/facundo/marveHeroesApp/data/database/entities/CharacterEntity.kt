package com.facundo.marveHeroesApp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.facundo.marveHeroesApp.domain.model.Character

@Entity(tableName = "characterInfo")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int= 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    //@ColumnInfo(name = "thumbnailExt") val thumbnailExt: String,
)

fun Character.toDatabase() = CharacterEntity(
    id = id,
    name = name,
    description = description,
    thumbnail = thumbnail
)
