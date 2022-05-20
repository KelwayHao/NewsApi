package com.example.retrofithomework.domain.interactor

import com.example.retrofithomework.domain.models.NewsInfo
import io.reactivex.Observable
import io.reactivex.Single

interface NewsInteractor {
    fun getNews(searchWord: String): Single<NewsInfo>
}