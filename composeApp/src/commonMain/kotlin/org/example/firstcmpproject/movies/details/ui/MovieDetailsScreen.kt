package org.example.firstcmpproject.movies.details.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.example.firstcmpproject.core.DETAILS_BUTTON_ICON_SIZE
import org.example.firstcmpproject.core.MARGIN_40
import org.example.firstcmpproject.core.MARGIN_CARD_MEDIUM_2
import org.example.firstcmpproject.core.MARGIN_LARGE
import org.example.firstcmpproject.core.MARGIN_MEDIUM
import org.example.firstcmpproject.core.MARGIN_MEDIUM_2
import org.example.firstcmpproject.core.MOVIE_ITEM_HEIGHT
import org.example.firstcmpproject.core.TEXT_LARGE
import org.example.firstcmpproject.core.TEXT_REGULAR
import org.example.firstcmpproject.core.TEXT_SMALL
import org.example.firstcmpproject.core.TEXT_SMALL_2X
import org.example.firstcmpproject.movies.MovieItem
import org.example.firstcmpproject.movies.details.state.MovieDetailState
import org.example.firstcmpproject.movies.details.viewmodel.MovieDetailsViewModel
import org.example.firstcmpproject.redux.AppState
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun MovieDetailsRoute(
    viewModel: MovieDetailsViewModel,
    onTapMovie: (Long) -> Unit,
    onTapBack: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit){
        launch {
            viewModel.onTapBackSharedFlow.collectLatest {
                onTapBack()
            }
        }

        launch {
            viewModel.navigateToDetailsSharedFlow.collectLatest {
                onTapMovie(it)
            }
        }
    }

    MovieDetailScreen(state = state , onTapMovie = {
        viewModel.onTapMovie(it)
    }, onTapBack = {
        viewModel.onTapBack()
    })
}

@Composable
fun MovieDetailScreen(
    state: AppState,
    onTapMovie: (Long) -> Unit, onTapBack: () -> Unit
) {
    Scaffold(containerColor = Color.Black) {
        if(state.movieDetail != null){
            LazyColumn {
                item {
                    DetailMovieImage(image = state.movieDetail.getFullMoviePosterPath(),onTapBack = onTapBack)
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }
                item {
                    DetailMovieLogo()
                }
                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }
                item {
                    Text(
                        state.movieDetail.title ?: "",
                        color = Color.White,
                        fontSize = TEXT_LARGE,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }
                item {
                    MovieDetailInfo(movieVO = state.movieDetail)
                }
                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }
                item {
                    MovieDetailButtons()
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
                }
                item {
                    Text(
                        state.movieDetail.overview ?: "",
                        maxLines = 3,
                        color = Color.White,
                        fontSize = TEXT_REGULAR,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2,)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
                }

                item {
                    Text(
                        "Cast: Taron Egerton, Sofia Carson, Jason Bateman ... more",
                        color = Color.DarkGray,
                        fontSize = TEXT_SMALL,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }

                item {
                    Text(
                        "Director: Jaume Collet-Serra",
                        color = Color.DarkGray,
                        fontSize = TEXT_SMALL,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_CARD_MEDIUM_2))
                }

                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(MARGIN_40),
                        modifier = Modifier.padding(horizontal = MARGIN_40)
                    ) {
                        MovieDetailActionButton(Icons.Default.Add, "My List", modifier = Modifier)
                        MovieDetailActionButton(Icons.Default.ThumbUp, "Rate", modifier = Modifier)
                        MovieDetailActionButton(Icons.Default.Share, "SHare", modifier = Modifier)
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_LARGE))
                }

                item {
                    Text(
                        "More Like This",
                        color = Color.White,
                        fontSize = TEXT_LARGE,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = MARGIN_MEDIUM_2)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(MARGIN_MEDIUM))
                }

                item {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        contentPadding = PaddingValues(horizontal = MARGIN_MEDIUM_2),
                        modifier = Modifier.height((MOVIE_ITEM_HEIGHT + MARGIN_CARD_MEDIUM_2) * ((state.similarMovies.count() / 3) + 1)),
                        verticalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
                        horizontalArrangement = Arrangement.spacedBy(MARGIN_MEDIUM),
                    ) {
                        items((state.similarMovies)) {
                            MovieItem(movie = it, onTapMovie = onTapMovie)
                        }

                    }
                }

            }
        }


    }

}


@Composable
fun MovieDetailActionButton(icon: ImageVector, title: String, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(
                DETAILS_BUTTON_ICON_SIZE
            )
        )
        Text(title, color = Color.White, fontSize = TEXT_SMALL_2X)
    }
}

@Preview
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailScreen(onTapMovie = {}, onTapBack = {}, state = AppState())
}