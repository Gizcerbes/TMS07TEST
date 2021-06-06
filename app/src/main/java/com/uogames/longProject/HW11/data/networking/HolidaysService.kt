package com.uogames.longProject.HW11.data.networking

import com.uogames.longProject.HW11.data.dto.CountriesRequest
import com.uogames.longProject.HW11.data.dto.HolidaysRequest
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val myKey = "b27b7a10-e98e-4df4-ade7-7be21d55566a"

interface HolidaysService {

    @GET(value = "/v1/holidays?pretty&key=$myKey&upcoming")
    fun getFirstHoliday(
        @Query("country")
        country: String,
        @Query("year")
        year: String,
        @Query("month")
        month: String,
        @Query("day")
        day: String
    ): Observable<HolidaysRequest>

    @GET(value = "/v1/countries?pretty&key=${myKey}")
    fun getCountries(
    ):Observable<CountriesRequest>

}