package com.facundo.marveHeroesApp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.facundo.marveHeroesApp.domain.model.Routes
import com.facundo.marveHeroesApp.ui.screens.detailHeroes.DetailCharacter
//import com.facundo.marveHeroesApp.ui.screens.heroes.HeroesViewModel
import com.facundo.marveHeroesApp.ui.theme.MarveHeroesAppTheme
import com.facundo.marveHeroesApp.ui.screens.heroes.Heroes
import com.facundo.marveHeroesApp.ui.screens.heroes.HeroesScreen
import com.facundo.marveHeroesApp.ui.screens.heroes.HeroesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val heroesViewModel: HeroesViewModel by viewModels()





    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*heroesViewModel.viewModelScope.launch {

        }*/


        //Log.i("Test",heroesViewModel.getAllCharactersData(0))


        setContent {
            MarveHeroesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    //Greeting("Android")
                    val navigationController = rememberNavController()

                    NavHost(navController = navigationController, startDestination = Routes.Heroes.route){
                        composable(Routes.Heroes.route){
                            HeroesScreen(heroesViewModel,navigationController)
                        }
                        composable(Routes.DetailHeroe.route,
                            arguments = listOf(navArgument("characterId"){
                                type = NavType.IntType
                            }
                        )){ backStackEntry ->
                            DetailCharacter(navigationController,backStackEntry.arguments?.getInt("characterId")?:0)
                        }
                    }




                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarveHeroesAppTheme {
        Greeting("Android")
    }
}