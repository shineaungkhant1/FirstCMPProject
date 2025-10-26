package org.example.firstcmpproject.movies.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.details.state.MovieDetailState

class MovieDetailsViewModel(val movieId: Long) : ViewModel() {

    // Repository
    private val movieDetailsRepository = MovieRepository

    // State
    private val _state = MutableStateFlow(MovieDetailState())

    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            val movieDetails = movieDetailsRepository.getMovieDetails(movieId)
            _state.update { it.copy(movieDetail = movieDetails) }
            movieDetails?.genres?.firstOrNull()?.id.let { genreId ->
                val similarMovies = movieDetailsRepository.getMovieByGenres(genreId ?: 0).toMutableList()

                similarMovies.removeAll { it.id == movieId }

                _state.update { it.copy(similarMovies = similarMovies) }
            }

        }



    }

}