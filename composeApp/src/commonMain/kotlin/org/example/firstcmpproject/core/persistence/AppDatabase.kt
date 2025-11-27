package org.example.firstcmpproject.core.persistence

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import org.example.firstcmpproject.movies.data.vos.MovieVO
import org.example.firstcmpproject.movies.persistence.daos.MovieDao
import org.example.firstcmpproject.movies.persistence.type_converters.BelongToCollectionTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converters.GenreIdsTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converters.GenreListTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converters.OriginalCountryTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converters.ProductionCompanyListTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converters.ProductionCountryListTypeConverter
import org.example.firstcmpproject.movies.persistence.type_converters.SpokenLanguageListTypeConverter

@Database(
    entities = [
        MovieVO::class
    ], version = 1, exportSchema = false
)
@TypeConverters(
    BelongToCollectionTypeConverter::class,
    GenreIdsTypeConverter::class,
    GenreListTypeConverter::class,
    OriginalCountryTypeConverter::class,
    ProductionCountryListTypeConverter::class,
    ProductionCompanyListTypeConverter::class,
    SpokenLanguageListTypeConverter::class
)

@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
}

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase>{
    override fun initialize(): AppDatabase
}