package com.facundo.marveHeroesApp.data.model.comics

data class MarvelComicsResult(
    val attributionHTML: String = "",
    val attributionText: String = "",
    val code: Int = 0,
    val copyright: String = "",
    val `data`: Data? = null,
    val etag: String = "",
    val status: String = ""
)