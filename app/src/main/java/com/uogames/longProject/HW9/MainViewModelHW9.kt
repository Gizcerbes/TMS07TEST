package com.uogames.longProject.HW9

import android.app.Application
import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uogames.longProject.HW9.data.entities.RandomAdvice
import com.uogames.longProject.HW9.repository.RandomAdviceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*

class MainViewModelHW9(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val repository = RandomAdviceRepository()

    private val _advice = MutableLiveData<RandomAdvice>()
    val advice: LiveData<RandomAdvice> = _advice

    private val _timer = MutableLiveData<Int>()
    val time: LiveData<Int> = _timer


    fun loadAdvice() {
        ioScope.launch {
            val result = async { repository.loadCurrency() }

            launch(Dispatchers.Main) {
                object : CountDownTimer(10000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        _timer.postValue(millisUntilFinished.div(1000).toInt())
                    }

                    override fun onFinish() {
                        ioScope.launch { _advice.postValue(result.await()) }
                    }
                }.start()
            }

        }
    }


}