package com.facundo.marveHeroesApp.domain.repository




import com.facundo.marveHeroesApp.data.database.dao.CharacterDAO
import com.facundo.marveHeroesApp.data.database.entities.CharacterEntity
import com.facundo.marveHeroesApp.data.network.ComicService
import com.facundo.marveHeroesApp.domain.model.*
import com.facundo.marveHeroesApp.domain.model.toDomain
import javax.inject.Inject
import com.facundo.marveHeroesApp.domain.model.*

class ComicRepository @Inject constructor(private val api : ComicService,
                                          private val characterDAO: CharacterDAO,
){
    suspend fun getMarvelCharactersFromApi(offset: Int):List<Character> {
        val response = api.getMarvelCharacters(offset)
        return response.map { it.toDomain() }
    }

    suspend fun getMarvelCharactersFromDatabase():List<Character> {
        val response: List<CharacterEntity> = characterDAO.getAllCharacters()
        return response.map { it.toDomain() }

    }

    suspend fun insertCharacters(characters: List<CharacterEntity>){
        characterDAO.inssertAll(characters)
    }

    suspend fun clearCharacters(){
        characterDAO.deleteAllCharacters()
    }

}

