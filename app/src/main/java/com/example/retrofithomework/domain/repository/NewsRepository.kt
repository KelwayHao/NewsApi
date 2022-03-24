package com.example.retrofithomework.domain.repository

import com.example.retrofithomework.data.models.NewsResponse

interface NewsRepository {
    suspend fun getNewsResponse(searchWord: String): NewsResponse
}
