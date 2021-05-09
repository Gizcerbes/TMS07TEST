package com.uogames.longProject.HW5

data class User(
    val login: String,
    val password: String
) {

    companion object {
        val LOGIN = "LOGIN"
        val PASSWORD = "PASSWORD"
    }

}