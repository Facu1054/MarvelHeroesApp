package com.facundo.marveHeroesApp.data.model.comics

import com.facundo.marveHeroesApp.data.model.Stories
import com.facundo.marveHeroesApp.data.model.Thumbnail
import com.facundo.marveHeroesApp.data.model.Url
import com.google.gson.annotations.SerializedName

data class ResultComics(
    val characters: Characters,
    val collectedIssues: List<Any>,
    val collections: List<Any>,
    val creators: Creators,
    val dates: List<Date>,
    val description: String,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: Events,
    val format: String,
    val id: Int,
    val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    @SerializedName("series")
    val series: SeriesComics,
    val stories: Stories,
    val textObjects: List<TextObject>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Variant>
)