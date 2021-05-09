package com.uogames.longProject.HW5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.uogames.longProject.R

class SecondActivityHW5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_hw5)

        val textView = findViewById<TextView>(R.id.hider)

        textView.text = getString(R.string.welcome) + " " + intent.getStringExtra(User.LOGIN)



    }
}