package com.example.newsappitmo.di

import com.example.newsappitmo.data.remote.ApiFactory
import com.example.newsappitmo.data.repository.NewsRepositoryImpl
import com.example.newsappitmo.domain.repository.NewsRepository
import org.koin.dsl.module

val dataModule = module {
    single { ApiFactory().newsApi }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
}