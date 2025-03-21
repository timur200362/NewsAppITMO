package com.example.newsappitmo.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://newsapi.org/"

class ApiFactory {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApi by lazy {
        retrofit.create(ApiService::class.java)
    }
}