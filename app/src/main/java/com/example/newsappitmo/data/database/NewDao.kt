package com.example.newsappitmo.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewDao {
    @Insert
    suspend fun insertAll(news: List<NewEntity>)

    @Query("SELECT * FROM new")
    suspend fun getAll(): List<NewEntity>
}