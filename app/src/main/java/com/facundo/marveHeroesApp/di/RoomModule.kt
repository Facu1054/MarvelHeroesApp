package com.facundo.marveHeroesApp.di

import android.content.Context
import androidx.room.Room
import com.facundo.marveHeroesApp.data.database.AppSyncDatabase
import com.facundo.marveHeroesApp.data.database.CharacterDatabase
import com.facundo.marveHeroesApp.util.Constant.Companion.AppSync_DATABASE_NAME
import com.facundo.marveHeroesApp.util.Constant.Companion.CHARACTER_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {



    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): CharacterDatabase =
        Room.databaseBuilder(
            context,
            CharacterDatabase::class.java,
            CHARACTER_DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideRoomAppSync(@ApplicationContext context: Context): AppSyncDatabase =
        Room.databaseBuilder(
            context,
            AppSyncDatabase::class.java,
            AppSync_DATABASE_NAME
        ).build()


    @Singleton
    @Provides
    fun provideCharacterDAO(characterDatabase: CharacterDatabase) = characterDatabase.getCharacterDAO()

    @Singleton
    @Provides
    fun provideAppSyncDAO(appSyncDatabase: AppSyncDatabase) = appSyncDatabase.getAppSyncDao()
}