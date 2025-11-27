package org.example.firstcmpproject.redux

import org.reduxkotlin.Reducer

val reducer: Reducer<AppState> = { state, action  ->
    when (action){
        is Actions.ReducerActions.FeaturedMovieSuccessful -> {
            state.copy(featureMovie = action.featuredMovie)
        }
        is Actions.ReducerActions.MoviesByGenreSuccessful -> {
            state.copy(moviesByGenre = action.moviesByGenre)
        }
        is Actions.ReducerActions.FetchMovieDetailsSuccessful -> {
            state.copy(featureMovie = action.movieDetail)
        }

        is Actions.ReducerActions.FetchSimilarMoviesSuccessful -> {
            state.copy(similarMovies = action.similarMovies)
        }

        is Actions.ReducerActions.GetMovieDetailsDBSuccessful -> {
            state.copy(movieDetail = action.movieDetail)
        }

        else -> state
    }

}