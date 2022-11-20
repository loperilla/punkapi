package com.loperilla.punkapi.network.remote

import com.loperilla.punkapi.network.model.Beer
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {
    @GET("beers?per_page=10")
    suspend fun  getPaginatedBeers(
        @Query("page") nPage: Int,
        @Query("beer_name") beerName: String
    ): Response<List<Beer>>
}