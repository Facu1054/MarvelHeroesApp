package com.facundo.marveHeroesApp.domain


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.facundo.marveHeroesApp.data.database.entities.toDatabase
import com.facundo.marveHeroesApp.data.model.heroes.Result
import com.facundo.marveHeroesApp.domain.model.AppSyncModel
import com.facundo.marveHeroesApp.domain.model.Character
import com.facundo.marveHeroesApp.domain.repository.AppSyncRepository
import com.facundo.marveHeroesApp.domain.repository.ComicRepository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(
    val repository: ComicRepository,
    val appSyncRepository: AppSyncRepository
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(offset: Int): List<Character> {
        val characters = repository.getMarvelCharactersFromApi(offset = offset)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val currentDate = LocalDateTime.now().format(formatter)
        val appInfo = AppSyncModel(id = 1, lastUpdate = currentDate)

        /*val list = repository.getMarvelCharactersFromApi(offset = offset).map {
            it.toCharacters()
        }*/
        //if(repository.getMarvelCharactersFromDatabase().isNotEmpty() &&)

        return if (
            appSyncRepository.getAppSyncInfoFromDatabase().isNotEmpty()
            &&
            appSyncRepository.getAppSyncInfoFromDatabase()[0].lastUpdate == currentDate
        ) {
            Log.i("DesdeDB", "Desde la base de datos con conexion a Internet")
            repository.getMarvelCharactersFromDatabase()
        } else if (characters.isNotEmpty()) {
            Log.i("DesdeApi", "Desde la API")
            repository.clearCharacters()
            appSyncRepository.clearAppSyncInfo()
            //Log.i("currentDate",current)
            repository.insertCharacters(characters.map { it.toDatabase() })
            appSyncRepository.insertAppSyncInfo(appInfo.toDatabase())
            characters
        } else {
            Log.i("DesdeDB", "Desde la base de datos")
            repository.getMarvelCharactersFromDatabase()
        }

    }
}

