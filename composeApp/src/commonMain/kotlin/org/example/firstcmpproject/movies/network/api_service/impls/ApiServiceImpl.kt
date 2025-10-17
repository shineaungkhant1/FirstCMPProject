package org.example.firstcmpproject.movies.network.api_service.impls

import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import org.example.firstcmpproject.core.network.HttpClientProvider
import org.example.firstcmpproject.core.network.transformResult
import org.example.firstcmpproject.core.utils.API_KEY
import org.example.firstcmpproject.core.utils.GET_GENRES
import org.example.firstcmpproject.core.utils.GET_MOVIES_BY_GENRE
import org.example.firstcmpproject.core.utils.MOVIE_DETAILS
import org.example.firstcmpproject.core.utils.NOW_PLAYING_MOVIES
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.network.api_service.ApiService
import org.example.firstcmpproject.movies.network.responses.GenreListResponse
import org.example.firstcmpproject.movies.network.responses.MovieListResponse

object ApiServiceImpl : ApiService {
    override suspend fun getNowPlayingMovies(page: Int): MovieListResponse? {
       val httpResponse = HttpClientProvider.httpClient.get("$NOW_PLAYING_MOVIES?page=$page"){
            header(HttpHeaders.Authorization, "Bearer $API_KEY")
        }
//        return  httpResponse.body<MovieListResponse?>()

//        when(httpResponse.status.value){
//            in 200..299 -> {
//                return httpResponse.body<MovieListResponse?>()
//            }
//            else -> {
//               try {
//                   val errorMessage = httpResponse.body<NetflixError>()
//                   throw Exception(errorMessage.statusMessage)
//               } catch (_ : JsonConvertException){
//                     throw Exception(httpResponse.bodyAsText())
//               }
//            }
//        }
        return transformResult<MovieListResponse?>(httpResponse)
    }

    override suspend fun getGenres(): GenreListResponse? {
        val httpResponse = HttpClientProvider.httpClient.get(GET_GENRES){
            header(HttpHeaders.Authorization, "Bearer $API_KEY")
        }
        return  transformResult<GenreListResponse?>(httpResponse)
    }

    override suspend fun getMoviesByGenre(genderId: Int): MovieListResponse? {
        val httpResponse = HttpClientProvider.httpClient.get("$GET_MOVIES_BY_GENRE?with_genres=$genderId"){
            header(HttpHeaders.Authorization, "Bearer $API_KEY")
        }
        return  transformResult<MovieListResponse?>(httpResponse)
    }

    override suspend fun getMovieDetails(movieId: Long): MovieVO? {
        val httpResponse = HttpClientProvider.httpClient.get(MOVIE_DETAILS.replace("{movie_id}", movieId.toString())){
            header(HttpHeaders.Authorization, "Bearer $API_KEY")
        }
        return transformResult<MovieVO?>(httpResponse)
    }
}