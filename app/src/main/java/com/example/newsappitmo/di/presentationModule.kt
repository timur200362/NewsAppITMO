package com.example.newsappitmo.di

import com.example.newsappitmo.presentation.mvvm.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel<NewsViewModel> { NewsViewModel(get(), get(), get()) }
}