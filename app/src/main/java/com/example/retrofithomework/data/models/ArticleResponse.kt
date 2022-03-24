package com.example.retrofithomework.data.models

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("source")
    val source: SourceResponse,
    @SerializedName("author")
    val author: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val articleUrl: String?,
    @SerializedName("urlToImage")
    val previewUrlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("content")
    val content: String?
)
