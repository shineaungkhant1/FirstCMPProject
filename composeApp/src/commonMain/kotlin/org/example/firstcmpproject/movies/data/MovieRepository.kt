package org.example.firstcmpproject.movies.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.network.api_service.ApiService
import org.example.firstcmpproject.movies.network.api_service.impls.ApiServiceImpl

object MovieRepository {
    val apiService : ApiService = ApiServiceImpl

    suspend fun getNowPlayingMovies() : List<MovieVO>{
        return withContext(Dispatchers.IO){
            val  response = apiService.getNowPlayingMovies(1)
            return@withContext response?.results ?: listOf()
        }
    }

    suspend fun getGenres() : List<GenreVO>{
        return withContext(Dispatchers.IO){
            val  response = apiService.getGenres()
            return@withContext response?.genres ?: listOf()
        }
    }

    suspend fun getMovieByGenres(genreId : Int) : List<MovieVO>{
        return withContext(Dispatchers.IO){
            val  response = apiService.getMoviesByGenre(genreId)
            return@withContext response?.results ?: listOf()
        }
    }

//    suspend fun getMoviesWithFirestFiveGenres() : List<Pair<GenreVO, List<MovieVO>>>{
//        return  withContext(Dispatchers.IO){
//            val genreList = getGenres().take(5)
//            val moviesByGenre : List<Pair<GenreVO, List<MovieVO>>> = genreList.map { genre ->
//                val movies = getMovieByGenres(genre.id ?: -1)
//                Pair(genre, movies)
//            }
//            return@withContext moviesByGenre
//        }
//    }

    suspend fun getMoviesWithFirestFiveGenres() : List<Pair<GenreVO, List<MovieVO>>>{
        return  withContext(Dispatchers.IO){
            val genreList = getGenres()
           val moviesByGenreDefferList = genreList.take(5).map { genre ->
                async {
                    val moviesByGenre = getMovieByGenres(genre.id)
                    return@async Pair(genre,moviesByGenre)
                }
            }
            moviesByGenreDefferList.awaitAll()
        }
    }

    suspend fun getFeaturedMovie(): MovieVO? {
        /// Get Now Playing Movies
        return withContext(Dispatchers.IO) {
            val nowPlayingMovies = getNowPlayingMovies()

            val firstMovieId = nowPlayingMovies.firstOrNull()?.id

            val movieDetailDeferred = async {
                val movieDetail = getMovieDetails(firstMovieId ?: 0)
                return@async movieDetail
            }

            movieDetailDeferred.await()
        }

        /// First

        /// Use id of the first movie -> Get Movie Details

        /// Return
    }
    suspend fun getMovieDetails(movieId: Long): MovieVO? {
        return withContext(Dispatchers.IO) {
            apiService.getMovieDetails(movieId)
        }
    }
}