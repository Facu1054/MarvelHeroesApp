package com.facundo.marveHeroesApp.data.model.characters

data class DataCharacters(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)