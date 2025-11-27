package org.example.firstcmpproject.redux


import kotlinx.coroutines.launch
import org.example.firstcmpproject.movies.data.MovieRepository
import org.reduxkotlin.Dispatcher
import org.reduxkotlin.Store
import org.reduxkotlin.middleware

val asyncMiddleware = middleware{ store : Store<AppState>, next: Dispatcher, action: Any->
    val movieRepository = MovieRepository
    val scope = AppCoroutineScope
    when(action){
        Actions.MiddlewareActions.FetchFeatureMovie -> {
            scope.coroutineScope.launch {
                val featureMovie = movieRepository.getFeaturedMovie()
                next(Actions.ReducerActions.FeaturedMovieSuccessful(featureMovie))
            }
        }
        Actions.MiddlewareActions.FetchMoviesByGenre -> {
            scope.coroutineScope.launch {
                val moviesByGenres = movieRepository.getMoviesWithFirestFiveGenres()
                next(Actions.ReducerActions.MoviesByGenreSuccessful(moviesByGenres))
            }
        }

        is Actions.MiddlewareActions.FetchMovieDetailsAndSimilarMovies -> {
            scope.coroutineScope.launch {
                val movieDetail = movieRepository.getMovieDetails(action.movieId)
                next(Actions.ReducerActions.FetchMovieDetailsSuccessful(movieDetail))

                movieDetail?.genres?.firstOrNull()?.id.let {
                    val similarMovies = movieRepository.getMovieByGenres(it)
                    next(Actions.ReducerActions.FetchSimilarMoviesSuccessful(similarMovies))
                }
            }
        }

        is Actions.MiddlewareActions.GetMovieDetailsFromDB -> {
            scope.coroutineScope.launch {
                val movieDetail = MovieRepository.getMovieDetailsFromDB(action.movieId)
                next(Actions.ReducerActions.GetMovieDetailsDBSuccessful(movieDetail))
            }
        }
    }

}