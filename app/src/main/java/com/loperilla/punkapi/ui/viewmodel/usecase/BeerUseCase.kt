package com.loperilla.punkapi.ui.viewmodel.usecase

import com.loperilla.punkapi.network.model.Beer
import com.loperilla.punkapi.repository.BeerRepository
import javax.inject.Inject


class BeerUseCase @Inject constructor(
    private val repository: BeerRepository
) {
    suspend operator fun invoke(nPage: Int, beerName: String): List<Beer> {
        return repository.getBeersByName(nPage, beerName)
    }

    suspend fun getRandom(): Beer? {
        return repository.getRandom()
    }
}
