package com.facundo.marveHeroesApp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.facundo.marveHeroesApp.data.database.dao.AppSyncDao
import com.facundo.marveHeroesApp.data.database.dao.CharacterDAO
import com.facundo.marveHeroesApp.data.database.entities.CharacterEntity


@Database(entities = [CharacterEntity::class], version = 2)
abstract class CharacterDatabase:RoomDatabase() {

    abstract fun getCharacterDAO(): CharacterDAO
    //abstract fun getAppSyncDAO(): AppSyncDao
}