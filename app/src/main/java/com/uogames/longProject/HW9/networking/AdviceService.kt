package com.uogames.longProject.HW9.networking

import com.uogames.longProject.HW9.data.dto.RandomAdviceResponse
import retrofit2.Response
import retrofit2.http.GET

interface AdviceService {

    @GET("/advice")
    suspend fun loadRandomAdvice(): Response<RandomAdviceResponse>

}