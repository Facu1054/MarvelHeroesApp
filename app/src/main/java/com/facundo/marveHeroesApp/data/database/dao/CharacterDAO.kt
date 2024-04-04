package com.facundo.marveHeroesApp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.facundo.marveHeroesApp.data.database.entities.CharacterEntity

@Dao
interface CharacterDAO {

    @Query("SELECT * FROM characterInfo")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inssertAll(chacracters:List<CharacterEntity>)

    @Query("DELETE FROM characterInfo")
    suspend fun deleteAllCharacters()
}