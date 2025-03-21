package com.example.newsappitmo.domain.usecase.interfaces

import com.example.newsappitmo.data.database.NewEntity

interface GetAllNewsFromDatabaseUseCase {
    suspend fun getAll(): List<NewEntity>
}