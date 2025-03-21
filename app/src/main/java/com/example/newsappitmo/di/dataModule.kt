package com.example.newsappitmo.di

import androidx.room.Room
import com.example.newsappitmo.data.database.NewDatabase
import com.example.newsappitmo.data.remote.ApiFactory
import com.example.newsappitmo.data.repository.NewsRepositoryImpl
import com.example.newsappitmo.domain.repository.NewsRepository
import org.koin.dsl.module

val dataModule = module {
    single { ApiFactory().newsApi }
    single<NewDatabase> { Room.databaseBuilder(get(), NewDatabase::class.java, "NewDatabase.db").build() }
    single { get<NewDatabase>().newDao() }
    single<NewsRepository> { NewsRepositoryImpl(get(), get()) }
}