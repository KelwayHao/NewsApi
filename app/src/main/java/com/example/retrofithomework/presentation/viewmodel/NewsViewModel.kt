package com.example.retrofithomework.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofithomework.domain.interactor.NewsInteractor
import com.example.retrofithomework.domain.models.BaseItem

class NewsViewModel(private val newsInteractor: NewsInteractor): ViewModel() {
    private val _news = MutableLiveData<List<BaseItem>>()
    val news: LiveData<List<BaseItem>> get() = _news

    init {
        loadData()
    }

    private fun loadData(){
        val items = listOf<BaseItem>(

        )

        _news.value = items
    }
}