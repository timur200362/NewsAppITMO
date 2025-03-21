package com.example.newsappitmo.domain.repository

import com.example.newsappitmo.data.remote.response.NewsResponse

interface NewsRepository {
    suspend fun getNews(queryName: String): NewsResponse
}