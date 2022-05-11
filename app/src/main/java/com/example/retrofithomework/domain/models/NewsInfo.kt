package com.example.retrofithomework.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsInfo(
    val amountNews: String,
    val listNews: List<BaseItem>
) : Parcelable
