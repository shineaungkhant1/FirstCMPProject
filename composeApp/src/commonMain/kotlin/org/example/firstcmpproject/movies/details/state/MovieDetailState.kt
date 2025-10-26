package org.example.firstcmpproject.movies.details.state

import org.example.firstcmpproject.movies.data.vos.MovieVO

data class MovieDetailState(
    val movieDetail: MovieVO? = null,
    val similarMovies: List<MovieVO> = listOf(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
}