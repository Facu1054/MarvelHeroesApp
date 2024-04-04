package com.facundo.marveHeroesApp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.facundo.marveHeroesApp.data.database.entities.AppSyncEntity

@Dao
interface AppSyncDao {
    @Query("SELECT * FROM appSync")
    suspend fun getAllAppSyncData(): List<AppSyncEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inssertAll(appSyncInfo: AppSyncEntity)

    @Query("DELETE FROM appSync")
    suspend fun deleteAppSyncData()
}