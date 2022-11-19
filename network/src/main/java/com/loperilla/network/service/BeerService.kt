package com.loperilla.network.service

import com.loperilla.network.RetrofitInstance.RetrofitHelper.getRetrofit
import com.loperilla.network.model.Beer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BeerService {
    private val retrofit = getRetrofit()

    suspend fun getBeers(nPage: Int, beerName: String): Flow<List<Beer>> {
        val service = retrofit.create(BeerApi::class.java)
        return flow {
            emit(service.getPaginatedBeers(nPage, beerName))
        }
    }
}