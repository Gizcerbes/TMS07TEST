package com.uogames.longProject.HW9.repository

import com.uogames.longProject.HW9.data.entities.RandomAdvice
import com.uogames.longProject.HW9.mappers.RandomAdviceMapper
import com.uogames.longProject.HW9.networking.AdviceApi

class RandomAdviceRepository {

    private val api = AdviceApi.provideRetrofit()
    private val mapper = RandomAdviceMapper()

    suspend fun  loadCurrency(): RandomAdvice? {
        val response = api.loadRandomAdvice()
        return if(response.isSuccessful){
            response.body()?.let { mapper.map(it) }
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }


}