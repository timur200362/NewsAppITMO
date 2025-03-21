package com.example.newsappitmo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NewEntity::class],
    autoMigrations = [

    ],
    version = 1
)
abstract class NewDatabase: RoomDatabase() {
    abstract fun newDao(): NewDao
}