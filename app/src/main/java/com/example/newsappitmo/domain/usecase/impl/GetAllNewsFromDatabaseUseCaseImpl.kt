package com.example.newsappitmo.domain.usecase.impl

import com.example.newsappitmo.data.database.NewEntity
import com.example.newsappitmo.domain.repository.NewsRepository
import com.example.newsappitmo.domain.usecase.interfaces.GetAllNewsFromDatabaseUseCase

class GetAllNewsFromDatabaseUseCaseImpl(
    private val newsRepository: NewsRepository
) : GetAllNewsFromDatabaseUseCase {
    override suspend fun getAll(): List<NewEntity> {
        return newsRepository.getAll()
    }
}