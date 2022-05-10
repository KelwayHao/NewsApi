package com.example.retrofithomework.domain.interactor

import android.util.Log
import com.example.retrofithomework.domain.models.NewsInfo
import com.example.retrofithomework.domain.repository.NewsRepository
import com.example.retrofithomework.utils.extensions.toBaseItems
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class NewsInteractorImpl(private val repository: NewsRepository) : NewsInteractor {
    override fun getNews(searchWord: String): Single<NewsInfo> {
        return repository.getNewsResponse(searchWord).map { response ->
            NewsInfo(
                response.totalResults.toString(),
                response.article.toBaseItems()
            )
        }.subscribeOn(Schedulers.io())
    }
}
