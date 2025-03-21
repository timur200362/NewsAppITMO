package com.example.newsappitmo.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappitmo.data.remote.response.NewsResponse
import com.example.newsappitmo.domain.usecase.interfaces.GetNewsUseCase
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {
    private val _news = MutableLiveData<NewsResponse>()
    val news: LiveData<NewsResponse>
        get() = _news

    fun getNews(queryName: String) {
        viewModelScope.launch {
            _news.value = getNewsUseCase.invoke(queryName)
        }
    }
}