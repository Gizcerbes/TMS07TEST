package com.uogames.longProject.HW7.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_table")
data class Item(
    val name: String,
    val description: String,
    val image: String,
    val dateOpen: Long,
    val startPay: Double,
    var currentParticipant: String,
    private var currentPay: Double = startPay
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    fun getCurrentPay(): Double = currentPay

    fun setBet(participant: String, pay: Double) {
        if (pay > currentPay) {
            currentPay = pay
            currentParticipant = participant
        }
    }


}