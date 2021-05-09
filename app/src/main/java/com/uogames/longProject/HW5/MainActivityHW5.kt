package com.uogames.longProject.HW5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.uogames.longProject.R

class MainActivityHW5 : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw5)

        val login = findViewById<TextInputLayout>(R.id.login)
        val password = findViewById<TextInputLayout>(R.id.password)
        val registration = findViewById<Button>(R.id.registration)

        registration.setOnClickListener {
            if (checkIn(login, password)) {
                val dialog = RegisterDialog()
                dialog.show(supportFragmentManager, RegisterDialog.TAG)
            }
        }
    }

    fun checkIn(login: TextInputLayout, password: TextInputLayout): Boolean {
        val loginText = login.editText?.text.toString()
        val passwordText = password.editText?.text.toString()
        login.error = ""
        password.error = ""

        if (loginText.isEmpty()) {
            login.error = getString(R.string.error_login_empty)
        }

        if (passwordText.isEmpty()) {
            password.error = getString(R.string.error_password_empty)
        } else if (passwordText.length < 8) {
            password.error = getString(R.string.error_password_short)
        }

        if (login.error.isNullOrEmpty() && password.error.isNullOrEmpty() && !viewModel.addUser(
                loginText,
                passwordText
            )
        ) {
            login.error = getString(R.string.error_check_login)
            password.error = getString(R.string.error_check_password)
        }

        return login.error.isNullOrEmpty() && password.error.isNullOrEmpty()
    }
}