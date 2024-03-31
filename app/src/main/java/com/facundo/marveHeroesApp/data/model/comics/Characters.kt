package com.facundo.marveHeroesApp.data.model.comics

import com.facundo.marveHeroesApp.data.model.Item

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)