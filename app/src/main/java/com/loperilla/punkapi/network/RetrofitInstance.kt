package com.loperilla.punkapi.network

import com.loperilla.punkapi.network.remote.BeerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitInstance {
    private const val BASE_URL = "https://api.punkapi.com/v2/"

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkhttpClient())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): BeerApi {
        return retrofit.create(BeerApi::class.java)
    }

    private fun provideOkhttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.connectTimeout(20, TimeUnit.SECONDS)
        client.readTimeout(30, TimeUnit.SECONDS)
        client.writeTimeout(30, TimeUnit.SECONDS)
        return client.build()
    }
}