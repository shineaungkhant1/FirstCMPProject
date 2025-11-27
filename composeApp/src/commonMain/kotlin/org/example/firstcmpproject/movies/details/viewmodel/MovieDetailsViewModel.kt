package org.example.firstcmpproject.movies.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
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

    var subscription : StoreSubscription? = null


//    init {
//        viewModelScope.launch {
//            val movieDetails = movieDetailsRepository.getMovieDetails(movieId)
//            _state.update { it.copy(movieDetail = movieDetails) }
//            movieDetails?.genres?.firstOrNull()?.id.let { genreId ->
//                val similarMovies = movieDetailsRepository.getMovieByGenres(genreId).toMutableList()
//
//                similarMovies.removeAll { it.id == movieId }
//
//                _state.update { it.copy(similarMovies = similarMovies) }
//            }
//
//        }
//
//        viewModelScope.launch {
//            val  movieDetails = movieDetailsRepository.getMovieDetailsFromDB(movieId)
//            println("Current Movie Details ===> $movieDetails")
//            _state.update { it.copy(movieDetail = movieDetails) }
//
//        }
//
//
//    }

    init {
        store.dispatch(Actions.MiddlewareActions.FetchMovieDetailsAndSimilarMovies(movieId))
        store.dispatch(Actions.MiddlewareActions.GetMovieDetailsFromDB(movieId))

        viewModelScope.launch {
            subscription = store.subscribe{
                _state.update { store.state }
            }
        }
    }

    override fun onCleared() {
        subscription?.invoke()
        super.onCleared()
    }

}