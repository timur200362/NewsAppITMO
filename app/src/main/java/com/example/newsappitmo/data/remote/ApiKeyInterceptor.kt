package com.example.newsappitmo.data.remote

import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY = "746bb463b3814e6096e6b57522cc2973"

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newUrl = request.url.newBuilder()
            .addQueryParameter("apiKey", API_KEY)
            .build()
        val newRequest = request.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }
}