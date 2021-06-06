package com.uogames.longProject.HW11.data.repository

import com.uogames.longProject.HW11.data.dto.CountriesRequest
import com.uogames.longProject.HW11.data.dto.HolidaysRequest
import com.uogames.longProject.HW11.data.mappers.CountriesMapper
import com.uogames.longProject.HW11.data.mappers.HolidaysMapper
import com.uogames.longProject.HW11.data.networking.HolidaysApi
import io.reactivex.rxjava3.core.Observable

class HolidaysRepository {
    private val api = HolidaysApi.provideRetrofit()
    private val countriesMapper = CountriesMapper()
    private val holidaysMapper = HolidaysMapper()

    fun loadCountries(): Observable<CountriesRequest> {
        return api.getCountries()
    }

    fun loadFirstHoliday(
        country: String,
        year: String,
        month: String,
        day: String
    ): Observable<HolidaysRequest> {
        return api.getFirstHoliday(
            country = country,
            year = year,
            month = month,
            day = day
        )
    }

}