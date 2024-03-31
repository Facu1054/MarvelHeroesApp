package com.facundo.marveHeroesApp.domain.model

import com.facundo.marveHeroesApp.data.model.Thumbnail

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String,
    val thumbnailExt: String,
    val comics: List<String>,
)
