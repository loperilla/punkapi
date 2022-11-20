package com.loperilla.punkapi.ui.viewmodel

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loperilla.punkapi.network.model.Beer
import com.loperilla.punkapi.usecase.BeerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    private val beerUseCase: BeerUseCase
) : ViewModel() {

    private var beersLiveData: MutableLiveData<List<Beer>> = MutableLiveData()
    fun getBeersLiveData(): LiveData<List<Beer>> = beersLiveData

    fun loadBeers(nPage: Int, beerName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = beerUseCase(nPage, beerName)
                if (result.isEmpty()) {
                    return@withContext
                }

                beersLiveData.postValue(result)
            }
        }
    }
}
