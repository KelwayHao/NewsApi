package com.example.retrofithomework.data.models

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Long?,
    @SerializedName("articles")
    val article: List<ArticleResponse>
)
