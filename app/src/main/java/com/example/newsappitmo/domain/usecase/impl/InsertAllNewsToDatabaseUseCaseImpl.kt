package com.example.newsappitmo.domain.usecase.impl

import com.example.newsappitmo.data.database.NewEntity
import com.example.newsappitmo.domain.repository.NewsRepository
import com.example.newsappitmo.domain.usecase.interfaces.InsertAllNewsToDatabaseUseCase

class InsertAllNewsToDatabaseUseCaseImpl(
    private val newsRepository: NewsRepository
) : InsertAllNewsToDatabaseUseCase {
    override suspend fun insertAll(news: List<NewEntity>) {
        newsRepository.insertAll(news)
    }
}