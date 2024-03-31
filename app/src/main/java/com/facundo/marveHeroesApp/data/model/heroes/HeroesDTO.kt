package com.facundo.marveHeroesApp.data.model.heroes

data class HeroesDTO(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)