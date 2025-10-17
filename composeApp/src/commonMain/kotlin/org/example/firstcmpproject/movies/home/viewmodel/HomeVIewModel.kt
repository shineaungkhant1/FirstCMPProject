package org.example.firstcmpproject.movies.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.home.state.HomeState

class HomeVIewModel : ViewModel() {
    val movieRepository = MovieRepository;

    private val _state = MutableStateFlow(HomeState())

    val state = _state.asStateFlow()

    init {
        // Featured Movies
//        viewModelScope.launch {
//            val nowPlayingMovies = movieRepository.getNowPlayingMovies()
//            val firstMovie = nowPlayingMovies.firstOrNull()
//            if (firstMovie != null) {
//                val detailedMovie = movieRepository.getMovieDetails(firstMovie.id)
//                _state.update {
//                    it.copy(featureMovie = detailedMovie)
//                }
//            }
//        }

        // Featured Movies
        viewModelScope.launch {
//            val featuredMovie = movieRepository.getNowPlayingMovies().firstOrNull()
            val featureMovie = movieRepository.getFeaturedMovie()
            _state.update {
                it.copy(
                    featureMovie = featureMovie
                )
            }
        }

        viewModelScope.launch {
            val moviesByGenres = movieRepository.getMoviesWithFirestFiveGenres()
            _state.update {
                it.copy(moviesByGenre = moviesByGenres)
            }
        }
    }
}