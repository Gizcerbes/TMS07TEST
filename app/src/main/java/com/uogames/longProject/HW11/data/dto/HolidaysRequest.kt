package com.uogames.longProject.HW11.data.dto


import com.google.gson.annotations.SerializedName

data class HolidaysRequest(
    @SerializedName("holidays")
    val holidays: List<HolidayRequest?>?,
    @SerializedName("requests")
    val requests: Requests?,
    @SerializedName("status")
    val status: Number?,
    @SerializedName("warning")
    val warning: String?
) {
    data class HolidayRequest(
        @SerializedName("country")
        val country: String?,
        @SerializedName("date")
        val date: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("observed")
        val observed: String?,
        @SerializedName("public")
        val `public`: Boolean?,
        @SerializedName("uuid")
        val uuid: String?,
        @SerializedName("weekday")
        val weekday: WeekdayRequest?
    ) {
        data class WeekdayRequest(
            @SerializedName("date")
            val date: DateRequest?,
            @SerializedName("observed")
            val observed: Observedrequest?
        ) {
            data class DateRequest(
                @SerializedName("name")
                val name: String?,
                @SerializedName("numeric")
                val numeric: String?
            )

            data class Observedrequest(
                @SerializedName("name")
                val name: String?,
                @SerializedName("numeric")
                val numeric: String?
            )
        }
    }

    data class Requests(
        @SerializedName("available")
        val available: Number?,
        @SerializedName("resets")
        val resets: String?,
        @SerializedName("used")
        val used: Number?
    )
}