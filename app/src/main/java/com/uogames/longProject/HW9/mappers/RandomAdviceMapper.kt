package com.uogames.longProject.HW9.mappers

import com.uogames.longProject.HW9.data.dto.RandomAdviceResponse
import com.uogames.longProject.HW9.data.entities.RandomAdvice

class RandomAdviceMapper: Mapper<RandomAdviceResponse, RandomAdvice> {
    override fun map(from: RandomAdviceResponse): RandomAdvice {
        return RandomAdvice(
            advice = from.slip?.advice.orEmpty()
        )
    }
}