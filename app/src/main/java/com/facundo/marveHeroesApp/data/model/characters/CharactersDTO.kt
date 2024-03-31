package com.facundo.marveHeroesApp.data.model.characters

data class CharactersDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val dataCharacters: DataCharacters,
    val etag: String,
    val status: String
)