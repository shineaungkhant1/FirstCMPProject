package org.example.firstcmpproject

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.example.firstcmpproject.auth.ui.NetflixLoginScreen
import org.example.firstcmpproject.core.NetflixSansTypography
import org.example.firstcmpproject.core.persistence.DatabaseDriverFactory
import org.example.firstcmpproject.core.persistence.DatabaseProvider
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.details.ui.MovieDetailScreen
import org.example.firstcmpproject.movies.details.ui.MovieDetailsRoute
import org.example.firstcmpproject.movies.details.viewmodel.MovieDetailsViewModel
import org.example.firstcmpproject.movies.home.ui.HomeRoute
import org.example.firstcmpproject.movies.home.viewmodel.HomeVIewModel
import org.example.firstcmpproject.movies.network.api_service.impls.ApiServiceImpl

@Composable
fun App(
    databaseDriverFactory: DatabaseDriverFactory
) {

    // Initialize Database
    DatabaseProvider.initDatabase(databaseDriverFactory)

    val navController: NavHostController = rememberNavController()


//    LaunchedEffect(key1 = Unit){
//        try {
//            val genres = MovieRepository.getGenres()
//            println("Genres ====> $genres")
//        } catch (e: Exception) {
//            println("Error ===> ${e.message}" )
//        }
//
//        try {
//            val genres = MovieRepository.getMovieByGenres(genreId = 28)
//            println("Movies By Genre Id ====> $genres")
//        } catch (e: Exception) {
//            println("Error ===> ${e.message}" )
//        }
//
//        try {
//            val movieByFirstFiveGenre = MovieRepository.getMoviesWithFirestFiveGenres()
//            println("Movies With First Five Genre Id ====> $movieByFirstFiveGenre")
//        } catch (e: Exception) {
//            println("Error ===> ${e.message}" )
//        }
//
//        try {
//            val movieDetails = MovieRepository.getMovieDetails(movieId = 1156594)
//            println("Movie Details ====> $movieDetails")
//        } catch (e: Exception) {
//            println("Error ===> ${e.message}" )
//        }
//    }

    MaterialTheme(typography = NetflixSansTypography()) {
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

            composable<NavRoutes.Home> {

                val homeViewModel = viewModel { HomeVIewModel() }


                HomeRoute(
                    viewModel = homeViewModel,
                    navigateToDetail = {
                    navController.navigate(NavRoutes.MovieDetail(it.toLong())) {

                    }
                })
            }

            composable<NavRoutes.MovieDetail> { backStackEntry ->
                val args = backStackEntry.toRoute<NavRoutes.MovieDetail>()
                val movieId = args.movieId
                val movieDetailsViewModel = viewModel { MovieDetailsViewModel(movieId.toLong()) }
                MovieDetailsRoute(
                    viewModel = movieDetailsViewModel,
                    onTapMovie = {
                        navController.navigate(NavRoutes.MovieDetail(it))
                    },
                    onTapBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}


@Serializable
sealed class NavRoutes {
    @Serializable
    object Login

    @Serializable
    object Home

    @Serializable
    data class MovieDetail(val movieId: Long)
}


