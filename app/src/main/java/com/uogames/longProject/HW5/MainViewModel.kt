package com.uogames.longProject.HW5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputLayout

class MainViewModel : ViewModel() {

    private val users = HashMap<String, String>()

    var selectedUser = Pair<String, String>("", "")

    fun addUser(login: String, password: String): Boolean {
        if (users.containsKey(login)) return false
        users.put(login, password)
        selectedUser = Pair(login, password)
        return true
    }
}