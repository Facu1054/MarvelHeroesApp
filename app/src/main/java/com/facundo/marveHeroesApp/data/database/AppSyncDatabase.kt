package com.facundo.marveHeroesApp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.facundo.marveHeroesApp.data.database.dao.AppSyncDao
import com.facundo.marveHeroesApp.data.database.dao.CharacterDAO
import com.facundo.marveHeroesApp.data.database.entities.AppSyncEntity
import com.facundo.marveHeroesApp.data.database.entities.CharacterEntity


@Database(entities = [AppSyncEntity::class], version = 1)
abstract class AppSyncDatabase: RoomDatabase() {

    abstract fun getAppSyncDao(): AppSyncDao
}