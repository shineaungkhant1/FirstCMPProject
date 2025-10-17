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
    val belongsToCollection: BelongsToCollectionVO,

    @SerialName("budget")
    val budget: Long? ,

    @SerialName("genres")
    val genres: List<GenreVO>?,

    @SerialName("homepage")
    val homepage: String?,

    @SerialName("imdb_id")
    val imdbId: String?,

    @SerialName("original_country")
    val originalCountry: String?,

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

}


//
//{
//    "adult": false,
//    "backdrop_path": "/XSTGtPVegdHD1xy5GPuK0tURTQ.jpg",
//    "belongs_to_collection": {
//    "id": 468552,
//    "name": "Wonder Woman Collection",
//    "poster_path": "/8AQRfTuTHeFTddZN4IUAqprN8Od.jpg",
//    "backdrop_path": "/n9KlvCOBFDmSyw3BgNrkUkxMFva.jpg"
//},
//    "budget": 200000000,
//    "genres": [
//    {
//        "id": 28,
//        "name": "Action"
//    },
//    {
//        "id": 12,
//        "name": "Adventure"
//    },
//    {
//        "id": 14,
//        "name": "Fantasy"
//    }
//    ],
//    "homepage": "https://www.warnerbros.com/movies/wonder-woman-1984",
//    "id": 464052,
//    "imdb_id": "tt7126948",
//    "origin_country": [
//    "US"
//    ],
//    "original_language": "en",
//    "original_title": "Wonder Woman 1984",
//    "overview": "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy.",
//    "popularity": 11.2302,
//    "poster_path": "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
//    "production_companies": [
//    {
//        "id": 174,
//        "logo_path": "/kgJaIcKZZK4lTazer55XrgWDEvp.png",
//        "name": "Warner Bros. Pictures",
//        "origin_country": "US"
//    },
//    {
//        "id": 114152,
//        "logo_path": "/xYfrnGFXxrEy5x5OVThunxHYScK.png",
//        "name": "The Stone Quarry",
//        "origin_country": "US"
//    },
//    {
//        "id": 128064,
//        "logo_path": "/13F3Jf7EFAcREU0xzZqJnVnyGXu.png",
//        "name": "DC Films",
//        "origin_country": "US"
//    },
//    {
//        "id": 507,
//        "logo_path": "/aRmHe6GWxYMRCQljF75rn2B9Gv8.png",
//        "name": "Atlas Entertainment",
//        "origin_country": "US"
//    }
//    ],
//    "production_countries": [
//    {
//        "iso_3166_1": "US",
//        "name": "United States of America"
//    }
//    ],
//    "release_date": "2020-12-16",
//    "revenue": 169601036,
//    "runtime": 151,
//    "spoken_languages": [
//    {
//        "english_name": "English",
//        "iso_639_1": "en",
//        "name": "English"
//    }
//    ],
//    "status": "Released",
//    "tagline": "A new era of wonder begins.",
//    "title": "Wonder Woman 1984",
//    "video": false,
//    "vote_average": 6.394,
//    "vote_count": 8782
//}


