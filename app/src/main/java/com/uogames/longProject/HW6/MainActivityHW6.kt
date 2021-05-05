package com.uogames.longProject.HW6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.uogames.longProject.R

class MainActivityHW6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw6)
        Picasso.get().load(getString(R.string.link_nine_may)).fetch()
        Picasso.get().load(getString(R.string.link_victory_day)).fetch()
    }
}