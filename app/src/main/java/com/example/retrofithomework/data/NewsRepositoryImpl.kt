package com.example.retrofithomework.data

import com.example.retrofithomework.data.models.NewsResponse
import com.example.retrofithomework.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(private val api: NewsApi) : NewsRepository {

    override suspend fun getNewsResponse(searchWord: String): NewsResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.getEverything(
                query = searchWord,
                language = "en",
                domains = "techcrunch.com, engadget.com"
            )
        }
    }

}