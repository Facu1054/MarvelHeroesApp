package com.facundo.marveHeroesApp.domain



import android.os.Build
import androidx.annotation.RequiresExtension
import com.facundo.marveHeroesApp.data.model.comics.MarvelComicsResult
import com.facundo.marveHeroesApp.domain.model.Character
import com.facundo.marveHeroesApp.domain.repository.MarvelRepository
import com.facundo.marveHeroesApp.util.Response
import com.facundo.marveHeroesApp.util.Response.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHeroUseCase @Inject constructor(
    private val repository: MarvelRepository
){



    //suspend operator fun invoke():ComicResponse? = repository.getMarvel()
    //suspend operator fun invoke(offset:Int): MarvelComicsResult? = repository.getMarvel()
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend operator fun invoke(offset:Int): Flow<Response<List<Character>>> = flow{
        try {
           emit(Response.Loading<List<Character>>())
            /*val list = repository.getAllCharacters(offset = offset).dataCharacters.results.map {
                it.toCharacter()

            }*/
            val list = repository.getAllCharacters(offset = offset).data.results.map {
                it.toCharacters()
            }
            CharactersProvider.characters = list
            emit(Response.Success<List<Character>>(list))

        }catch (e: HttpException){
            emit(Response.Error<List<Character>>(e.printStackTrace().toString()))
        }
        catch (e:IOException){
            emit(Response.Error(e.printStackTrace().toString()))
        }
    }


}