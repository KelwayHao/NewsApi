package com.example.retrofithomework.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithomework.domain.interactor.NewsInteractor
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.models.NewsInfo
import kotlinx.coroutines.launch

class NewsViewModel(private val newsInteractor: NewsInteractor): ViewModel() {
    private val _news = MutableLiveData<NewsInfo>()
    val news: LiveData<NewsInfo> get() = _news

    fun setWord(word: String){
        loadData(word)
    }

    private fun loadData(word: String) {
        viewModelScope.launch {
            _news.postValue(newsInteractor.getNews(word))
        }
    }
}