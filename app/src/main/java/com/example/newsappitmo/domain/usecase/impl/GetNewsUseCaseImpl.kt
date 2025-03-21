package com.example.newsappitmo.domain.usecase.impl

import com.example.newsappitmo.data.remote.response.NewsResponse
import com.example.newsappitmo.domain.repository.NewsRepository
import com.example.newsappitmo.domain.usecase.interfaces.GetNewsUseCase

class GetNewsUseCaseImpl(
    private val newsRepository: NewsRepository
) : GetNewsUseCase {
    override suspend fun invoke(queryName: String): NewsResponse {
        return newsRepository.getNews(queryName)
    }
}