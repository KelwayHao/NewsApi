package com.example.retrofithomework.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofithomework.domain.interactor.NewsInteractor
import com.example.retrofithomework.domain.models.NewsInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class NewsViewModel(private val newsInteractor: NewsInteractor) : ViewModel() {
    private val _news = MutableLiveData<NewsInfo>()
    val news: LiveData<NewsInfo> get() = _news

    fun setWord(word: String) {
        loadData(word)
    }

    private fun loadData(word: String) {
        val result = newsInteractor.getNews(word)
            .delay(5, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _news.postValue(it) },
                { it.printStackTrace() }
            )
    }
}