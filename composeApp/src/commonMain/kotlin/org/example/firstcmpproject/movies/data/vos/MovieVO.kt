package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.firstcmpproject.core.utils.FEATURED_MOVIE_IMAGE_BASE_URL
import org.example.firstcmpproject.core.utils.MOVIE_ITEM_IMAGE_BASE_URL

@Serializable
class MovieVO(
    @SerialName("adult")
    val adult: Boolean,

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionVO?,

    @SerialName("budget")
    val budget: Long? ,

    @SerialName("genres")
    val genres: List<GenreVO>?,

    @SerialName("homepage")
    val homepage: String?,

    @SerialName("imdb_id")
    val imdbId: String?,

    @SerialName("original_country")
    val originalCountry: List<String>?,

    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompanyVO>?,

    @SerialName("production_countries")
    val productionCountries: List<ProductionCountryVO>?,

    @SerialName("revenue")
    val revenue: Long?,

    @SerialName("runtime")
    val runtime: Int?,

    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageVO>?,

    @SerialName("status")
    val status: String?,

    @SerialName("tagline")
    val tagline: String?,

    @SerialName("genre_ids")
    val genreIds: List<Int>? = null,

    @SerialName("id")
    val id: Long,

    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    val originalTitle: String,

    @SerialName("overview")
    val overview: String? = null,

    @SerialName("popularity")
    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("release_date")
    val releaseDate: String? = null,

    @SerialName("title")
    val title: String? = null,

    @SerialName("video")
    val video: Boolean? = null,

    @SerialName("vote_average")
    val voteAverage: Double? = null,

    @SerialName("vote_count")
    val voteCount: Int? = null
) {
    fun getFullMoviePosterPath(): String {
        return "$FEATURED_MOVIE_IMAGE_BASE_URL$posterPath"
    }

    fun getFullMovieBackdropPath(): String {
        return "$MOVIE_ITEM_IMAGE_BASE_URL$backdropPath"
    }

    override fun toString(): String {
        return "MovieVO(adult=$adult, backdropPath='$backdropPath', belongsToCollection=$belongsToCollection, budget=$budget, genres=$genres, homepage=$homepage, imdbId=$imdbId, originalCountry=$originalCountry, productionCompanies=$productionCompanies, productionCountries=$productionCountries, revenue=$revenue, runtime=$runtime, spokenLanguages=$spokenLanguages, status=$status, tagline=$tagline, genreIds=$genreIds, id=$id, originalLanguage='$originalLanguage', originalTitle='$originalTitle', overview=$overview, popularity=$popularity, posterPath='$posterPath', releaseDate=$releaseDate, title=$title, video=$video, voteAverage=$voteAverage, voteCount=$voteCount)"
    }

    fun ferHourAndMinutes(): String {
        val hours = runtime?.div(60)
        val minutes = runtime?.rem(60)
        return "${hours}h ${minutes}m"
    }

}





