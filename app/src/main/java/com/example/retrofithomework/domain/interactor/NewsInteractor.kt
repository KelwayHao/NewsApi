package com.example.retrofithomework.domain.interactor

import com.example.retrofithomework.domain.models.NewsInfo

interface NewsInteractor {
    suspend fun getNews(searchWord: String): NewsInfo
}