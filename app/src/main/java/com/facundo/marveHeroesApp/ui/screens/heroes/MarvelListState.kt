package com.facundo.marveHeroesApp.ui.screens.heroes

import com.facundo.marveHeroesApp.domain.model.Character

data class MarvelListState(
    val isLoading: Boolean = false,
    val characterList : List<Character> = emptyList(),
    val error: String = ""
)
