package com.facundo.marveHeroesApp.data.model.characters

import com.facundo.marveHeroesApp.data.model.Item

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)