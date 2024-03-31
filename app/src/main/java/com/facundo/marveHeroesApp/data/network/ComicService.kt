package com.facundo.marveHeroesApp.data.network

/*

import com.facundo.marveHeroesApp.data.model.heroes.HeroesDTO
import com.facundo.marveHeroesApp.data.model.heroes.Result
import com.superheroapp.data.network.ComicsApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ComicService @Inject constructor(
    private val api: ComicsApiClient
) {
    //val retrofitCreate = retrofit.create(ComicsApiClient::class.java)

    suspend fun getMarvelCharacters(offset: Int): List<Result> {
        return withContext(Dispatchers.IO){
            val response = api.getAllCharacters2(offset = offset.toString())
            response.body() ?: emptyList()
        }

    }
}

*/