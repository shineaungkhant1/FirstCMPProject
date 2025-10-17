package org.example.firstcmpproject.movies.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.movies.home.state.HomeState
import org.example.firstcmpproject.movies.home.viewmodel.HomeVIewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun HomeRoute(
    viewModel: HomeVIewModel,
    navigateToDetail : (Int) -> Unit = {}

){


    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(
        state,
        navigateToDetail = navigateToDetail
    )
}

@Composable
fun HomeScreen(state: HomeState,navigateToDetail : (Int) -> Unit = {}) {
    Scaffold(containerColor = Color.Black, topBar = {
        HomeAppBar()
    }) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {

                MoveCategoriesSection(modifier = Modifier.padding(start = MARGIN_MEDIUM_2))
            }

            item {
                if(state.featureMovie != null){
                    FeaturedMovie(
                        movie = state.featureMovie,
                        modifier = Modifier.clickable(
                        onClick = {
                            navigateToDetail(state.featureMovie.id.toInt())
                        }
                    ))
                } else {
                    println("Featured movie is null")
                }

            }
            // Space
            item {
                Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
            }

            // Movies and Categories

            items(state.moviesByGenre.count()) { index ->
               GenreNameAndMovies(genre = state.moviesByGenre[index].first, movieList = state.moviesByGenre[index].second,onTapMovie = navigateToDetail)
            }

        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(state = HomeState())
}