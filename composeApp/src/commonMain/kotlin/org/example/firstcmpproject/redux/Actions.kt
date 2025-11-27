package org.example.firstcmpproject.redux

import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.MovieVO

sealed interface Actions {

    sealed interface  MiddlewareActions: Actions {
        // Home Screen
        object FetchFeatureMovie: MiddlewareActions
        object FetchMoviesByGenre: MiddlewareActions

        data class FetchMovieDetailsAndSimilarMovies(val movieId : Long): MiddlewareActions
        data class GetMovieDetailsFromDB(val movieId : Long): MiddlewareActions
    }

    sealed interface ReducerActions: Actions {
        // Home Screen
        data class FeaturedMovieSuccessful(val featuredMovie: MovieVO?): ReducerActions
        data class MoviesByGenreSuccessful(val moviesByGenre: List<Pair<GenreVO, List<MovieVO>>>): ReducerActions

        // Details
        data class FetchMovieDetailsSuccessful(val movieDetail: MovieVO?): ReducerActions
        data class FetchSimilarMoviesSuccessful(val similarMovies: List<MovieVO>): ReducerActions

        data class GetMovieDetailsDBSuccessful(val movieDetail: MovieVO?): ReducerActions

    }

}