package com.uogames.longProject.HW11.data.entities

import com.google.gson.annotations.SerializedName

class Holidays(
    val holidays: List<Holiday>,
) {
    data class Holiday(
        val date: String,
        val name: String
    )
}