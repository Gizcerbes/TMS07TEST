package com.uogames.longProject.HW11.data.mappers

import com.uogames.longProject.HW11.data.dto.CountriesRequest

interface Mapper<T,E> {

    fun map (from: T): E

}