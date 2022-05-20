package com.example.retrofithomework.domain.repository

import com.example.retrofithomework.data.models.NewsResponse
import io.reactivex.Observable
import io.reactivex.Single

interface NewsRepository {
    fun getNewsResponse(searchWord: String): Single<NewsResponse>
}
