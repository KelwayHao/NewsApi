package com.example.retrofithomework.domain.interactor

import com.example.retrofithomework.data.models.NewsResponse
import com.example.retrofithomework.domain.models.BaseItem
import com.example.retrofithomework.domain.repository.NewsRepository
import com.example.retrofithomework.utils.extensions.toBaseItem

class NewsInteractorImpl(private val repository: NewsRepository) : NewsInteractor {
    override suspend fun getNews(searchWord: String): Map<String, List<BaseItem>> {
        val response: NewsResponse = repository.getNewsResponse(searchWord)
        val mapList = mutableMapOf<String, List<BaseItem>>()
        mapList[response.totalResults.toString()] = response.article.toBaseItem()
        return mapList.toMap()
    }
}