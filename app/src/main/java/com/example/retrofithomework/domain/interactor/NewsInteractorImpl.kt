package com.example.retrofithomework.domain.interactor

import com.example.retrofithomework.domain.models.NewsInfo
import com.example.retrofithomework.domain.repository.NewsRepository
import com.example.retrofithomework.utils.extensions.toNewsInfo

class NewsInteractorImpl(private val repository: NewsRepository) : NewsInteractor {
    override suspend fun getNews(searchWord: String): NewsInfo {
        return repository.getNewsResponse(searchWord).toNewsInfo()
    }
}