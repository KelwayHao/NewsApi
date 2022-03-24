package com.example.retrofithomework.domain.models

data class News(
    val author: String?,
    val title: String?,
    val description: String?,
    val articleUrl: String?,
    val previewUrlToImage: String?,
    val content: String?,
    val idNewsChannel: String?,
    val nameNewsChannel: String
) : BaseItem()