package org.example.firstcmpproject.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.example.firstcmpproject.core.persistence.AppDatabase
import org.example.firstcmpproject.core.persistence.DatabaseFactory
import org.example.firstcmpproject.movies.data.MovieRepository
import org.example.firstcmpproject.movies.network.api_service.ApiService
import org.example.firstcmpproject.movies.network.api_service.impls.ApiServiceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module


val sharedModule : Module = module {
    single <AppDatabase>{
        get<DatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
        .build()
    }

    single<ApiService> { ApiServiceImpl() }
    single<MovieRepository> { MovieRepository(apiService = get(), appDatabase = get()) }
}