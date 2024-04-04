package com.facundo.marveHeroesApp.ui.screens.heroes

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facundo.marveHeroesApp.data.model.comics.Characters
import com.facundo.marveHeroesApp.data.model.comics.MarvelComicsResult
//import com.facundo.marveHeroesApp.domain.GetHeroUseCase
import com.facundo.marveHeroesApp.domain.GetHeroesUseCase
import com.facundo.marveHeroesApp.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.facundo.marveHeroesApp.util.Response.*
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class HeroesViewModel @Inject constructor(
    private val heroesUseCase: GetHeroesUseCase,
    //private val marvelHeroesUseCase: GetHeroesUseCase,

    ) : ViewModel(){
    private val _marvelValue = MutableStateFlow<MarvelListState>(MarvelListState())
    var marvelValue: StateFlow<MarvelListState> = _marvelValue

    private val _marvelValue2 = MutableStateFlow<MutableList<Character>>(mutableListOf())
    var marvelValue2: StateFlow<MutableList<Character>> = _marvelValue2

    var loading = mutableStateOf(false)

    /*init {
        getAllCharactersData(0)
    }*/
    @RequiresApi(Build.VERSION_CODES.O)
    fun onCreate() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {

            val result = heroesUseCase(0)

            if (!result.isNullOrEmpty()) {
                _marvelValue2.value = result.toMutableList() ?: mutableListOf()
                Log.i("resultTest",result.toString())
                loading.value = false

            }
        }


    }



    /*fun loadMoreSuperHeroes(offset: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            loading.value = true
            val result = marvelHeroesUseCase(offset)

            if (!result.isNullOrEmpty()) {
                _marvelValue2.value.addAll(result)
                loading.value = false
            }
        }
    }*/



    /*@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getAllCharactersData(offset:Int) = viewModelScope.launch(Dispatchers.IO) {
        heroesUseCase(offset = offset).collect{
            when(it){
                is Success ->{
                    //loading.value = false
                    _marvelValue.value = MarvelListState(characterList = it.data ?: emptyList())
                    Log.i("Test",marvelValue.value.characterList.toString())
                }
                is Error -> {
                    //loading.value = false
                    _marvelValue.value = MarvelListState(error = it.message ?: "Unexpected Error")
                    Log.i("Test"," error")
                }
                is Loading -> {
                    //loading.value = true
                    _marvelValue.value = MarvelListState(isLoading = true)
                    Log.i("Test","loadging")
                }
            }
        }

    }*/

}
