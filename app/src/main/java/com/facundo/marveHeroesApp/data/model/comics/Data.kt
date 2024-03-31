package com.facundo.marveHeroesApp.data.model.comics

import com.google.gson.annotations.SerializedName

data class Data(
    val count: Int?,
    val limit: Int?,
    val offset: Int?,
    @SerializedName("results")
    val results: List<ResultComics?>?,
    val total: Int?
)