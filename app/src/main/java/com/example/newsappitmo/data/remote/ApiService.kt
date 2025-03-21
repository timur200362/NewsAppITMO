package com.example.newsappitmo.data.remote

import com.example.newsappitmo.data.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/everything")
    suspend fun loadNews(@Query("q") queryName: String): NewsResponse
}