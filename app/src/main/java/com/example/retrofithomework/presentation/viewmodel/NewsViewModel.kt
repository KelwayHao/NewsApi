package com.example.retrofithomework.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithomework.domain.interactor.NewsInteractor
import com.example.retrofithomework.domain.models.NewsInfo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class NewsViewModel(private val newsInteractor: NewsInteractor): ViewModel() {
    private val _news = MutableLiveData<NewsInfo>()
    val news: LiveData<NewsInfo> get() = _news

    fun setWord(word: String){
        loadData(word)
    }

    private fun loadData(word: String) {
        val result = newsInteractor.getNews(word)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({_news.postValue(it)},{it.printStackTrace()})
    }
}