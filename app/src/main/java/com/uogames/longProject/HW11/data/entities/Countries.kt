package com.uogames.longProject.HW11.data.entities

data class Countries(
    val countries: List<Countries.Country>,
) {
    data class Country(
        val code: String,
        val flag: String,
        val name: String,
    )
}