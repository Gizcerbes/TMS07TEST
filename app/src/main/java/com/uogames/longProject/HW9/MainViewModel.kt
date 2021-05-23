package com.uogames.longProject.HW9

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uogames.longProject.HW9.data.entities.RandomAdvice
import com.uogames.longProject.HW9.repository.RandomAdviceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val repository = RandomAdviceRepository()

    private val _advice = MutableLiveData<RandomAdvice>()
    val advice: LiveData<RandomAdvice> = _advice


    fun loadAdvice() {
        ioScope.launch { _advice.postValue(repository.loadCurrency()) }
    }


}