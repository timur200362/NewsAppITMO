package com.example.newsappitmo.di

import com.example.newsappitmo.domain.usecase.impl.GetAllNewsFromDatabaseUseCaseImpl
import com.example.newsappitmo.domain.usecase.impl.GetNewsUseCaseImpl
import com.example.newsappitmo.domain.usecase.impl.InsertAllNewsToDatabaseUseCaseImpl
import com.example.newsappitmo.domain.usecase.interfaces.GetAllNewsFromDatabaseUseCase
import com.example.newsappitmo.domain.usecase.interfaces.GetNewsUseCase
import com.example.newsappitmo.domain.usecase.interfaces.InsertAllNewsToDatabaseUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetNewsUseCase> { GetNewsUseCaseImpl(get()) }
    factory<GetAllNewsFromDatabaseUseCase> { GetAllNewsFromDatabaseUseCaseImpl(get()) }
    factory<InsertAllNewsToDatabaseUseCase> { InsertAllNewsToDatabaseUseCaseImpl(get()) }
}