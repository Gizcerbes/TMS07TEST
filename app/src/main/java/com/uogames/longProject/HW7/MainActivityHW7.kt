package com.uogames.longProject.HW7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.uogames.longProject.R

class MainActivityHW7 : AppCompatActivity() {

    private val viewModel: MainViewModelHW7 by lazy {
        ViewModelProvider.AndroidViewModelFactory(
            application
        ).create(MainViewModelHW7::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw7)
    }
}