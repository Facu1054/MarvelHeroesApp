package com.facundo.marveHeroesApp.ui.screens.heroes

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.facundo.marveHeroesApp.domain.model.Character
import com.facundo.marveHeroesApp.domain.model.Routes

//import com.facundo.marveHeroesApp.ui.screens.heroes.HeroesViewModel

//myComics: HeroesViewModel
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun HeroesScreen(heroesViewModel: HeroesViewModel, navigationController: NavHostController){
    //val flowTest by heroesViewModel.marvelValue.collectAsStateWithLifecycle()
    val flowTest by heroesViewModel.marvelValue2.collectAsStateWithLifecycle()

    var state by remember {
        //heroesViewModel.getAllCharactersData(0)
        heroesViewModel.onCreate()
        mutableStateOf(false)
    }

    Heroes(heroesData = flowTest, navigationController = navigationController,heroesViewModel)
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun Heroes(heroesData: MutableList<Character>, navigationController: NavHostController,heroesViewModel: HeroesViewModel){
    //val flowTransaction by myComics.marvel.collectAsStateWithLifecycle()


    //LazyVerticalStaggeredGrid(columns =StaggeredGridCells.Fixed(2),modifier = Modifier.fillMaxSize()) {
    //if (heroesData.isLoading) {
    if (heroesViewModel.loading.value) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            content = {
                items(heroesData) { item ->
                    Log.i("Test", (item.thumbnail).toString())
                    /*AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(item.thumbnail+"."+item.thumbnailExt)
                            .crossfade(true)
                            .build(),
                        contentDescription ="Image Marvel Character"
                    )*/

                    ItemHeroe(item, navigationController)


                }
            })
    }

}

@Composable
fun ItemHeroe(character: Character, detailHero: NavHostController){
    Card(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .clickable {
                detailHero.navigate(Routes.DetailHeroe.createRoute(character.id))
            }
            .padding(8.dp)
    ) {
        Column {

            /*Image(
                painter = painterResource(id = (character.thumbnail + "." + character.thumbnailExt).toInt()),
                contentDescription = "Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )*/
            Text(text = character.name, modifier = Modifier.align(Alignment.CenterHorizontally))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(
                        character.thumbnail.replace(
                            "http",
                            "https"
                        )
                    )
                    .crossfade(true)
                    .build(),
                contentDescription = "Image Marvel Character",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

