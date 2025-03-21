package com.example.newsappitmo.di

import com.example.newsappitmo.domain.usecase.impl.GetNewsUseCaseImpl
import com.example.newsappitmo.domain.usecase.interfaces.GetNewsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetNewsUseCase> { GetNewsUseCaseImpl(get()) }
}