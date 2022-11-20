package com.loperilla.punkapi.network.remote

import android.util.Log
import com.loperilla.punkapi.network.model.Beer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BeerService @Inject constructor(private val api: BeerApi) {
    suspend fun getBeers(nPage: Int, beerName: String): List<Beer> {
        return withContext(Dispatchers.IO) {
            val response = api.getPaginatedBeers(nPage, beerName)
            response.body() ?: emptyList()
        }
    }
}