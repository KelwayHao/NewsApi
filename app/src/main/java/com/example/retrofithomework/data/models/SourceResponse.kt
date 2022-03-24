package com.example.retrofithomework.data.models

import com.google.gson.annotations.SerializedName

data class SourceResponse(
    @SerializedName("id")
    val idNewsChannel: String?,
    @SerializedName("name")
    val nameNewsChannel: String
)
