package com.loperilla.punkapi.network.model

import com.google.gson.annotations.SerializedName

data class Beer(
    @SerializedName("name") val name: String,
    @SerializedName("image_url") val image_url: String,
    @SerializedName("first_brewed") val firstBrewed: String,
    @SerializedName("description") val description: String
)