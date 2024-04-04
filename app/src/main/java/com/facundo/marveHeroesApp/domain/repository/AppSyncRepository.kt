package com.facundo.marveHeroesApp.domain.repository

import com.facundo.marveHeroesApp.data.database.dao.AppSyncDao
import com.facundo.marveHeroesApp.data.database.dao.CharacterDAO
import com.facundo.marveHeroesApp.data.database.entities.AppSyncEntity
import com.facundo.marveHeroesApp.data.database.entities.CharacterEntity
import com.facundo.marveHeroesApp.domain.model.AppSyncModel
import com.facundo.marveHeroesApp.domain.model.Character
import com.facundo.marveHeroesApp.domain.model.toDomain
import javax.inject.Inject

class AppSyncRepository @Inject constructor(private val appSyncDAO: AppSyncDao) {

    suspend fun getAppSyncInfoFromDatabase():List<AppSyncModel> {
        val response: List<AppSyncEntity> = appSyncDAO.getAllAppSyncData()
        return response.map { it.toDomain() }

    }

    suspend fun insertAppSyncInfo(appSyncInfo: AppSyncEntity){
        appSyncDAO.inssertAll(appSyncInfo)
    }

    suspend fun clearAppSyncInfo(){
        appSyncDAO.deleteAppSyncData()
    }
}