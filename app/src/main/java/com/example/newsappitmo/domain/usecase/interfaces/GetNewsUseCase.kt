package com.example.newsappitmo.domain.usecase.interfaces

import com.example.newsappitmo.data.remote.response.NewsResponse

interface GetNewsUseCase {
    suspend operator fun invoke(queryName: String): NewsResponse
}