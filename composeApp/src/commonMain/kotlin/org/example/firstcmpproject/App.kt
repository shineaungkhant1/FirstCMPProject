package org.example.firstcmpproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import kotlinx.serialization.Serializable
import org.example.firstcmpproject.auth.ui.NetflixLoginScreen
import org.example.firstcmpproject.movie.details.ui.MovieDetailScreen
import org.example.firstcmpproject.movie.home.ui.HomeScreen

@Composable
fun App() {
    val navController: NavHostController = rememberNavController()

    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Login
        ) {
            composable<NavRoutes.Login> {
                NetflixLoginScreen(
                    onTapSignIn = {
                        navController.navigate(NavRoutes.Home) {
                            popUpTo(NavRoutes.Login) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable <NavRoutes.Home>{
                HomeScreen(navigateToDetail = {
                    navController.navigate(NavRoutes.MovieDetail(it) ){

                    }
                })
            }

            composable <NavRoutes.MovieDetail>{
                MovieDetailScreen()
            }
        }
    }
}


@Serializable
sealed class  NavRoutes{
    @Serializable
    object Login

    @Serializable
    object Home

    @Serializable
    data class MovieDetail(val movieId: Int)
}


