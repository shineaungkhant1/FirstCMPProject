package org.example.firstcmpproject.movies.persistence

import org.example.firstcmpproject.core.persistence.DatabaseProvider
import org.example.firstcmpproject.core.persistence.Movie
import org.example.firstcmpproject.movies.data.vos.MovieVO

object MovieDao {
    // Query
    val dbQuery = DatabaseProvider.database.dbQuery

    fun insertMovies(movies : List<MovieVO>){
        val moviesForPersistence : List<Movie> = movies.map {
            it.convertToPersistenceModel()
        }

        dbQuery.transaction{
            moviesForPersistence.forEach {
                dbQuery.insertPartialMovie(
                    adult = it.adult,
                    backDropPath = it.backDropPath,
                    genreIds = it.genreIds,
                    originalLanguage = it.originalLanguage,
                    originalTitle = it.originalTitle,
                    overview = it.overview,
                    popularity = it.popularity,
                    posterPath = it.posterPath,
                    releaseDate = it.releaseDate,
                    title = it.title,
                    video = it.video,
                    voteAverage = it.voteAverage,
                    voteCount = it.voteCount,
                    id = it.id,
                )
            }
        }

    }

    fun insertSingleMovie(movie : MovieVO){
        val movieForPersistence : Movie = movie.convertToPersistenceModel()
        with(movieForPersistence){
            dbQuery.insertFullMovie(
                id = id,
                adult = adult,
                backDropPath = backDropPath,
                belongsToCollection = belongsToCollection,
                budget = budget,
                genres = genres,
                homePage = homePage,
                imdbId = imdbId ,
                originalCountry = originalCountry ,
                genreIds = genreIds,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                overview = overview,
                popularity = popularity,
                posterPath = posterPath,
                prodictionCountries = prodictionCountries,
                productionCompanies = productionCompanies,
                releaseDate = releaseDate,
                revenue = revenue,
                runtime = runtime,
                spokenLanguages = spokenLanguages ,
                status = status,
                tagline = tagline,
                title = title,
                video = video,
                voteAverage = voteAverage,
                voteCount = voteCount
            )
        }
    }

    fun getMovieById(movieId : Long) : MovieVO?{
        val movie = dbQuery.getMovieById(movieId).executeAsOneOrNull()
        return movie?.convertToMovieVO()
    }

}