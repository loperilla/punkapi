package com.loperilla.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Beer(
    val name: String,
    @SerialName("image_url") val image_url: String
)