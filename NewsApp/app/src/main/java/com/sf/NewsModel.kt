package com.sf

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("imageUrl")
    val imagePath: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("summary")
    val summary: String?,
    var isFavorite: Boolean = false
)