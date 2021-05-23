package com.uogames.longProject.HW9.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}