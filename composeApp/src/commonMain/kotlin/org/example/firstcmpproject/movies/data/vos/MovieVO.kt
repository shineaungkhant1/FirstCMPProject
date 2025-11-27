package org.example.firstcmpproject.movies.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.firstcmpproject.core.utils.FEATURED_MOVIE_IMAGE_BASE_URL
import org.example.firstcmpproject.core.utils.MOVIE_ITEM_IMAGE_BASE_URL

@Serializable
@Entity(tableName = "movies")
class MovieVO(
    @SerialName("adult")
    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @SerialName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @SerialName("belongs_to_collection")
    @ColumnInfo(name = "belongs_to_collection")
    val belongsToCollection: BelongsToCollectionVO?,

    @SerialName("budget")
    @ColumnInfo(name = "budget")
    val budget: Long? ,

    @SerialName("genres")
    @ColumnInfo(name = "genres")
    val genres: List<GenreVO>?,

    @SerialName("homepage")
    @ColumnInfo(name = "homepage")
    val homepage: String?,

    @SerialName("imdb_id")
    @ColumnInfo(name = "imdb_id")
    val imdbId: String?,

    @SerialName("original_country")
    @ColumnInfo(name = "original_country")
    val originalCountry: List<String>?,

    @SerialName("production_companies")
    @ColumnInfo(name = "production_companies")
    val productionCompanies: List<ProductionCompanyVO>?,

    @SerialName("production_countries")
    @ColumnInfo(name = "production_countries")
    val productionCountries: List<ProductionCountryVO>?,

    @SerialName("revenue")
    @ColumnInfo(name = "revenue")
    val revenue: Long?,

    @SerialName("runtime")
    @ColumnInfo(name = "runtime")
    val runtime: Int?,

    @SerialName("spoken_languages")
    @ColumnInfo(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguageVO>?,

    @SerialName("status")
    @ColumnInfo(name = "status")
    val status: String?,

    @SerialName("tagline")
    @ColumnInfo(name = "tagline")
    val tagline: String?,

    @SerialName("genre_ids")
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>? = null,

    @SerialName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Long,

    @SerialName("original_language")
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    @SerialName("original_title")
    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @SerialName("overview")
    @ColumnInfo(name = "overview")
    val overview: String? = null,

    @SerialName("popularity")
    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @SerialName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String,

    @SerialName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: String? = null,

    @SerialName("title")
    @ColumnInfo(name = "title")
    val title: String? = null,

    @SerialName("video")
    @ColumnInfo(name = "video")
    val video: Boolean? = null,

    @SerialName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double? = null,

    @SerialName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int? = null
) {
    fun getFullMoviePosterPath(): String {
        return "$FEATURED_MOVIE_IMAGE_BASE_URL$posterPath"
    }

    fun getFullMovieBackdropPath(): String {
        return "$MOVIE_ITEM_IMAGE_BASE_URL$backdropPath"
    }


    fun ferHourAndMinutes(): String {
        val hours = runtime?.div(60)
        val minutes = runtime?.rem(60)
        return "${hours}h ${minutes}m"
    }

    override fun toString(): String {
        return "MovieVO(adult=$adult, backdropPath='$backdropPath', belongsToCollection=$belongsToCollection, budget=$budget, genres=$genres, homepage=$homepage, imdbId=$imdbId, originalCountry=$originalCountry, productionCompanies=$productionCompanies, productionCountries=$productionCountries, revenue=$revenue, runtime=$runtime, spokenLanguages=$spokenLanguages, status=$status, tagline=$tagline, genreIds=$genreIds, id=$id, originalLanguage='$originalLanguage', originalTitle='$originalTitle', overview=$overview, popularity=$popularity, posterPath='$posterPath', releaseDate=$releaseDate, title=$title, video=$video, voteAverage=$voteAverage, voteCount=$voteCount)"
    }


}





