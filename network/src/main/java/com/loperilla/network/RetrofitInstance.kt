package com.loperilla.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object RetrofitInstance {
    const val BASE_URL = "https://api.punkapi.com/v2/"
    private val contentType = MediaType.get("application/json")

    object RetrofitHelper {
        @OptIn(ExperimentalSerializationApi::class)
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(Json.asConverterFactory(contentType))
                .build()
        }
    }

}