package org.example.firstcmpproject.movies.persistence

import org.example.firstcmpproject.core.persistence.Movie
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.BelongsToCollectionVO
import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.data.vos.ProductionCompanyVO
import org.example.firstcmpproject.movies.data.vos.ProductionCountryVO
import org.example.firstcmpproject.movies.data.vos.SpokenLanguageVO

fun MovieVO.convertToPersistenceModel() : Movie {
    val belongToCollectionJsonString = universalJsonParser.encodeToString(this.belongsToCollection)
    val genresJsonString = universalJsonParser.encodeToString(this.genres)
    val genreIdsJsonString = universalJsonParser.encodeToString(this.genreIds)
    val productionCompaniesJsonString = universalJsonParser.encodeToString(this.productionCompanies)
    val productionCountriesJsonString = universalJsonParser.encodeToString(this.productionCountries)
    val spokenLanguagesJsonString = universalJsonParser.encodeToString(this.spokenLanguages)
    val originCountryJsonString = universalJsonParser.encodeToString(this.originalCountry)

    return Movie(
        id = this.id,
        adult = this.adult,
        backDropPath = this.backdropPath,
        belongsToCollection = belongToCollectionJsonString,
        budget = this.budget,
        genres = genresJsonString,
        genreIds = genreIdsJsonString,
        homePage = this.homepage,
        imdbId = this.imdbId,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.posterPath,
        productionCompanies = productionCompaniesJsonString,
        prodictionCountries = productionCountriesJsonString,
        releaseDate = this.releaseDate,
        revenue = this.revenue,
        runtime = this.runtime?.toLong(),
        spokenLanguages = spokenLanguagesJsonString,
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount?.toLong(),
        originalCountry = originCountryJsonString
    )
}

fun Movie.convertToMovieVO() : MovieVO{
    val belongsToCollection: BelongsToCollectionVO? =
        if(this.belongsToCollection != null) universalJsonParser.decodeFromString(this.belongsToCollection) else null

    val genres: List<GenreVO>? =
        if (this.genres != null) universalJsonParser.decodeFromString(this.genres) else null

    val genreIds: List<Int>? =
        if (this.genreIds != null) universalJsonParser.decodeFromString(this.genreIds) else null

    val productionCompanies: List<ProductionCompanyVO>? =
        if (this.productionCompanies != null) universalJsonParser.decodeFromString(this.productionCompanies) else null

   val productionCountries: List<ProductionCountryVO>? =
       if (this.prodictionCountries != null) universalJsonParser.decodeFromString(this.prodictionCountries) else null

    val spokenLanguages: List<SpokenLanguageVO>? =
        if (this.spokenLanguages != null) universalJsonParser.decodeFromString( string = this.spokenLanguages) else null

    val originCountry: List<String>? =
        if (this.originalCountry != null) universalJsonParser.decodeFromString(this.originalCountry) else null

    return MovieVO(
        id = this.id,
        adult = this.adult ?: false,
        backdropPath = this.backDropPath ?: "",
        belongsToCollection = belongsToCollection,
        budget = this.budget,
        genres = genres,
        genreIds = genreIds,
        homepage = this.homePage,
        imdbId = this.imdbId,
        originalLanguage = this.originalLanguage ?: "",
        originalTitle = this.originalTitle ?: "",
        overview = this.overview,
        popularity = this.popularity ?: 0.0,
        posterPath = this.posterPath ?: "",
        productionCompanies = productionCompanies,
        productionCountries = productionCountries,
        releaseDate = this.releaseDate,
        revenue = this.revenue,
        runtime = this.runtime?.toInt(),
        spokenLanguages = spokenLanguages,
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
        voteCount = this.voteCount?.toInt(),
        originalCountry = originCountry,
    )
}