package com.example.retrofithomework.data

import com.example.retrofithomework.data.models.NewsResponse
import com.example.retrofithomework.domain.repository.NewsRepository
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepositoryImpl(private val api: NewsApi) : NewsRepository {

    override fun getNewsResponse(searchWord: String): Single<NewsResponse> {

        return api.getEverything(
                query = searchWord,
                language = "en",
                domains = "techcrunch.com, engadget.com"
        )


        /*withContext(Dispatchers.IO) {
            return@withContext api.getEverything(
                query = searchWord,
                language = "en",
                domains = "techcrunch.com, engadget.com"
            )
        }*/
    }

}