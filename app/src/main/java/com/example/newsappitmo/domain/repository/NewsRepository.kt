package com.example.newsappitmo.domain.repository

import com.example.newsappitmo.data.database.NewEntity
import com.example.newsappitmo.data.remote.response.NewsResponse

interface NewsRepository {
    suspend fun getNews(queryName: String): NewsResponse
    suspend fun insertAll(news: List<NewEntity>)
    suspend fun getAll(): List<NewEntity>
}