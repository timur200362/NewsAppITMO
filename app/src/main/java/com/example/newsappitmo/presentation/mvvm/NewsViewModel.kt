package com.example.newsappitmo.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappitmo.data.database.NewEntity
import com.example.newsappitmo.data.remote.response.NewsResponse
import com.example.newsappitmo.domain.usecase.interfaces.GetAllNewsFromDatabaseUseCase
import com.example.newsappitmo.domain.usecase.interfaces.GetNewsUseCase
import com.example.newsappitmo.domain.usecase.interfaces.InsertAllNewsToDatabaseUseCase
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val getAllNewsFromDatabaseUseCase: GetAllNewsFromDatabaseUseCase,
    private val insertAllNewsToDatabaseUseCase: InsertAllNewsToDatabaseUseCase
) : ViewModel() {
    private val _news = MutableLiveData<NewsResponse>()
    val news: LiveData<NewsResponse>
        get() = _news

    private val _newsDb = MutableLiveData<List<NewEntity>>()
    val newsDb: LiveData<List<NewEntity>>
        get() = _newsDb

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun getNews(queryName: String) {
        viewModelScope.launch {
            _loading.value = true
            _news.value = getNewsUseCase.invoke(queryName)
            _loading.value = false
        }
    }
}