package com.example.retrofithomework.domain.interactor

import com.example.retrofithomework.domain.models.BaseItem

interface NewsInteractor {
    suspend fun getNews(searchWord: String): Map<String, List<BaseItem>>
}