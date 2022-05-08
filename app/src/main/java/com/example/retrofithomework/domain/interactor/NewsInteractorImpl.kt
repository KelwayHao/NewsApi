package com.example.retrofithomework.domain.interactor

import android.util.Log
import com.example.retrofithomework.domain.models.NewsInfo
import com.example.retrofithomework.domain.repository.NewsRepository
import com.example.retrofithomework.utils.extensions.toBaseItems
import io.reactivex.Single

class NewsInteractorImpl(private val repository: NewsRepository) : NewsInteractor {
    override fun getNews(searchWord: String): Single<NewsInfo> {
        return repository.getNewsResponse(searchWord).map {
            NewsInfo(
                it.totalResults.toString(),
                it.article.toBaseItems()
            )
        }
    }
}
