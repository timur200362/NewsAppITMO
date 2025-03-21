package com.example.newsappitmo.data.repository

import com.example.newsappitmo.data.remote.ApiService
import com.example.newsappitmo.data.remote.response.NewsResponse
import com.example.newsappitmo.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val apiService: ApiService
) : NewsRepository {
    override suspend fun getNews(queryName: String): NewsResponse {
        return apiService.loadNews(queryName)
    }
}