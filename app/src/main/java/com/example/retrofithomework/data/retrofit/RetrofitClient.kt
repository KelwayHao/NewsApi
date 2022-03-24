package com.example.retrofithomework.data.retrofit

import com.example.retrofithomework.data.NewsApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://newsapi.org/v2/"
    const val BASE_API_KEY = "99d33a759e954fd09cf5599b617a146d"

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getClient() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getNewsApi(): NewsApi = getClient().create(NewsApi::class.java)
}