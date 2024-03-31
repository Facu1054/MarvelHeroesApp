package com.facundo.marveHeroesApp.domain.model

sealed class Routes(val route:String) {
    object Heroes: Routes("heroes")
    object DetailHeroe: Routes("detailHero/{characterId}"){
        fun createRoute(characterId: Int): String = "detailHero/$characterId"
    }
}