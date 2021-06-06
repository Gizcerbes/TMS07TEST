package com.uogames.longProject.HW11.data.dto


import com.google.gson.annotations.SerializedName

data class CountriesRequest(
    @SerializedName("countries")
    val countries: List<CountryRequest?>?,
    @SerializedName("requests")
    val requests: Requests?,
    @SerializedName("status")
    val status: Number?
) {
    data class CountryRequest(
        @SerializedName("code")
        val code: String?,
        @SerializedName("codes")
        val codes: CodesRequest?,
        @SerializedName("flag")
        val flag: String?,
        @SerializedName("languages")
        val languages: List<String?>?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("subdivisions")
        val subdivisions: List<SubdivisionRequest?>?
    ) {
        data class CodesRequest(
            @SerializedName("alpha-2")
            val alpha2: String?,
            @SerializedName("alpha-3")
            val alpha3: String?,
            @SerializedName("numeric")
            val numeric: String?
        )

        data class SubdivisionRequest(
            @SerializedName("code")
            val code: String?,
            @SerializedName("languages")
            val languages: List<String?>?,
            @SerializedName("name")
            val name: String?
        )
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