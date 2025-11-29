package org.example.firstcmpproject.movies.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.home.actions.HomeActions
import org.example.firstcmpproject.movies.home.events.HomeEvents
import org.example.firstcmpproject.movies.home.state.HomeState
import org.example.firstcmpproject.redux.Actions
import org.example.firstcmpproject.redux.AppState
import org.reduxkotlin.Store
import org.reduxkotlin.StoreSubscription

class HomeVIewModel(val store : Store<AppState>) : ViewModel() {
    val movieRepository = MovieRepository;

//    private val _state = MutableStateFlow(HomeState())
    private val _state = MutableStateFlow(AppState())

    val state = _state.asStateFlow()

//    private val _navigateToDetailsSharedFlow : MutableSharedFlow<Long> = MutableSharedFlow()
//    val navigateToDetailsSharedFlow = _navigateToDetailsSharedFlow.asSharedFlow()

    private val _navigationSharedFlow : MutableSharedFlow<HomeEvents> = MutableSharedFlow()
    val navigationSharedFlow = _navigationSharedFlow.asSharedFlow()


    var subscription : StoreSubscription? = null

    init {
//         Featured Movies
        viewModelScope.launch {
            val nowPlayingMovies = movieRepository.getNowPlayingMovies()
            val firstMovie = nowPlayingMovies.firstOrNull()
            if (firstMovie != null) {
                val detailedMovie = movieRepository.getMovieDetails(firstMovie.id)
                _state.update {
                    it.copy(featureMovie = detailedMovie)
                }
            }
        }

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

//        viewModelScope.launch {
//            val moviesByGenres = movieRepository.getMoviesWithFirestFiveGenres()
//            _state.update {
//                it.copy(moviesByGenre = moviesByGenres)
//            }
//        }

        viewModelScope.launch {
            val moviesByGenres = movieRepository.getMoviesWithFirestFiveGenresFlow()
            _state.update {
                it.copy(moviesByGenre = moviesByGenres)
            }
        }
    }

    fun onAction(action: HomeActions) {
        when(action){
            is HomeActions.OnTapMovie -> {
                /// TODO: Side Effect Flow
               viewModelScope.launch {
                   _navigationSharedFlow.emit(HomeEvents.NavigateToDetails(action.movieId))
               }
            }
        }
    }

//    fun  onTapMovie(movieId: Long) {
//        viewModelScope.launch {
//            _navigateToDetailsSharedFlow.emit(movieId)
//        }
//    }



    override fun onCleared() {
        subscription?.invoke()

        super.onCleared()

    }
}
