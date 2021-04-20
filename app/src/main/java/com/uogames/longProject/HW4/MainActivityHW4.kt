package com.uogames.longProject.HW4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.uogames.longProject.R

class MainActivityHW4 : AppCompatActivity() {
    lateinit var viewModel: MainViewModelHW4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw4)
        viewModel = ViewModelProvider(this).get(MainViewModelHW4::class.java)

        viewModel.selectedFragment.observe(this){
            supportFragmentManager.beginTransaction().replace(R.id.hw4_container, it).commit()
        }

    }
}