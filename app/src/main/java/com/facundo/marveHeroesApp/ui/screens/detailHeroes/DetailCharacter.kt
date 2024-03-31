package com.facundo.marveHeroesApp.ui.screens.detailHeroes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun DetailCharacter(navigationController: NavHostController,characterId:Int) {

    Column {
        Text(text = characterId.toString())
    }
    /*Column {
        Text(text = character.name)
        Text(text = character.description)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(
                    character.thumbnail.replace(
                        "http",
                        "https"
                    ) + "." + character.thumbnailExt
                )
                .crossfade(true)
                .build(),
            contentDescription = "Image Marvel Character",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }*/
}
