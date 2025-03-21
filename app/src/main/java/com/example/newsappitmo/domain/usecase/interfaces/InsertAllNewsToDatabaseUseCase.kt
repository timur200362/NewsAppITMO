package com.example.newsappitmo.domain.usecase.interfaces

import com.example.newsappitmo.data.database.NewEntity

interface InsertAllNewsToDatabaseUseCase {
    suspend fun insertAll(news: List<NewEntity>)
}