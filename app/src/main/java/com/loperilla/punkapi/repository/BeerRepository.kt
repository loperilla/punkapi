package com.loperilla.punkapi.repository

import com.loperilla.punkapi.network.model.Beer
import com.loperilla.punkapi.network.remote.BeerService
import javax.inject.Inject

class BeerRepository @Inject constructor(private val service: BeerService) {
    suspend fun getBeersByName(nPage: Int, beerName: String): List<Beer> {
        return service.getBeers(nPage, beerName)
    }

    suspend fun getRandom(): Beer? {
        return service.getRandom()
    }
}
