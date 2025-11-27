package org.example.firstcmpproject.core.persistence

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

object AppDatabaseProvider {
    lateinit var db: AppDatabase

    fun initializeDatabase(databaseBuilder: RoomDatabase.Builder<AppDatabase>) {
        db = databaseBuilder
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .fallbackToDestructiveMigration(dropAllTables = true)
            .build()
    }
}