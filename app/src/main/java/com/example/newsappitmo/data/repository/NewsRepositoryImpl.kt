package com.example.newsappitmo.data.repository

import com.example.newsappitmo.data.database.NewEntity
import com.example.newsappitmo.data.database.NewDao
import com.example.newsappitmo.data.remote.ApiService
import com.example.newsappitmo.data.remote.response.NewsResponse
import com.example.newsappitmo.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val apiService: ApiService,
    private val newDao: NewDao
) : NewsRepository {
    override suspend fun getNews(queryName: String): NewsResponse {
        return apiService.loadNews(queryName)
    }

    override suspend fun insertAll(news: List<NewEntity>) {
        newDao.insertAll(news)
    }

    override suspend fun getAll(): List<NewEntity> {
        return newDao.getAll()
    }
}