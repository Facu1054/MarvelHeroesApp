package com.facundo.marveHeroesApp.data.model.heroes

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)