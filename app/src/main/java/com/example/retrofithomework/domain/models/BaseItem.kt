package com.example.retrofithomework.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


sealed class BaseItem : Parcelable

@Parcelize
data class Date(
    val dateNews: String
) : BaseItem()
@Parcelize
data class News(
    val author: String?,
    val title: String,
    val description: String,
    val articleUrl: String?,
    val previewUrlToImage: String,
    val content: String?,
    val idNewsChannel: String?,
    val nameNewsChannel: String?
) : BaseItem()

