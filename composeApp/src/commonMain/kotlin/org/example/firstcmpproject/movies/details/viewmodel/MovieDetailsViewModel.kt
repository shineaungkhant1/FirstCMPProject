package org.example.firstcmpproject.movies.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.details.state.MovieDetailState
import org.example.firstcmpproject.redux.Actions
import org.example.firstcmpproject.redux.AppState
import org.reduxkotlin.Store
import org.reduxkotlin.StoreSubscription

class MovieDetailsViewModel(val movieId: Long,val store: Store<AppState>) : ViewModel() {

    // Repository
    private val movieDetailsRepository = MovieRepository

    // State
//    private val _state = MutableStateFlow(MovieDetailState())
    private val _state = MutableStateFlow(AppState())

    val state = _state.asStateFlow()

    private val _navigateToDetailsSharedFlow : MutableSharedFlow<Long> = MutableSharedFlow()

    private  val _onTapBackSharedFlow : MutableSharedFlow<Unit> = MutableSharedFlow()

    val navigateToDetailsSharedFlow = _navigateToDetailsSharedFlow.asSharedFlow()

    val onTapBackSharedFlow = _onTapBackSharedFlow.asSharedFlow()

    var subscription : StoreSubscription? = null


    init {
        viewModelScope.launch {
            val movieDetails = movieDetailsRepository.getMovieDetails(movieId)
            _state.update { it.copy(movieDetail = movieDetails) }
            movieDetails?.genres?.firstOrNull()?.id.let { genreId ->
                val similarMovies = movieDetailsRepository.getMovieByGenres(genreId).toMutableList()

                similarMovies.removeAll { it.id == movieId }

                _state.update { it.copy(similarMovies = similarMovies) }
            }

        }

        viewModelScope.launch {
//            val  movieDetails = movieDetailsRepository.getMovieDetailsFromDB(movieId)
//            println("Current Movie Details ===> $movieDetails")
//            _state.update { it.copy(movieDetail = movieDetails) }

            movieDetailsRepository.getMovieDetailsFromDBFlow(movieId)
                .collect { movieDetails ->
                    _state.update { it.copy(movieDetail = movieDetails) }

                }

        }


    }


    fun onTapBack() {
        viewModelScope.launch {
            _onTapBackSharedFlow.emit(Unit)
        }
    }

    fun onTapMovie(movieId: Long) {
        viewModelScope.launch {
            _navigateToDetailsSharedFlow.emit(movieId)
        }
    }

    override fun onCleared() {
        subscription?.invoke()
        super.onCleared()
    }

}