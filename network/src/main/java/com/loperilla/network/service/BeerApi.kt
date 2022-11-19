package com.loperilla.network.service

import com.loperilla.network.model.Beer
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerApi {
    @GET("beers?page={nPages}&per_page=10&beer_name={beerName}")
    suspend fun getPaginatedBeers(
        @Path("nPages") nPage: Int,
        @Path("beerName") beerName: String
    ): List<Beer>
}