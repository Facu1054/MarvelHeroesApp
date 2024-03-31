package com.superheroapp.data.network

import com.facundo.marveHeroesApp.util.Constant
import com.facundo.marveHeroesApp.data.model.comics.MarvelComicsResult
import com.facundo.marveHeroesApp.data.model.heroes.HeroesDTO
import com.facundo.marveHeroesApp.data.model.heroes.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsApiClient{
    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query("ts") ts: String = Constant.ts,
        @Query("apikey") apiKey: String = Constant.API_KEY,
        @Query("hash") hash: String = Constant.hash(),
        @Query("limit") limit: String = Constant.LIMIT,
    ):Response<MarvelComicsResult>

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("ts") ts: String = Constant.ts,
        @Query("apikey") apiKey: String = Constant.API_KEY,
        @Query("hash") hash: String = Constant.hash(),
        @Query("offset") offset: String,
        @Query("limit") limit: String = Constant.LIMIT,
    ): HeroesDTO

    @GET("/v1/public/characters")
    suspend fun getAllCharacters2(
        @Query("ts") ts: String = Constant.ts,
        @Query("apikey") apiKey: String = Constant.API_KEY,
        @Query("hash") hash: String = Constant.hash(),
        @Query("offset") offset: String,
    ): Response<List<Result>>
}

