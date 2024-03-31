package com.facundo.marveHeroesApp.di

import com.facundo.marveHeroesApp.data.repository.MarvelRepositoryImpl
import com.facundo.marveHeroesApp.domain.repository.MarvelRepository
import com.superheroapp.data.network.ComicsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMarvelApi(): ComicsApiClient {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ComicsApiClient::class.java)
    }


    @Provides
    @Singleton
    fun provideMarvelRepository(api: ComicsApiClient): MarvelRepository {
        return MarvelRepositoryImpl(api)
    }
}