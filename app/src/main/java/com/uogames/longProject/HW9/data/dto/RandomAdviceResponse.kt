package com.uogames.longProject.HW9.data.dto


import com.google.gson.annotations.SerializedName

data class RandomAdviceResponse(
    @SerializedName("slip")
    val slip: Slip?
) {
    data class Slip(
        @SerializedName("advice")
        val advice: String?,
        @SerializedName("id")
        val id: Int?
    )
}