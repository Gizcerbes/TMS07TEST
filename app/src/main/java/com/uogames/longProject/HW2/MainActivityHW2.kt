package com.uogames.longProject.HW2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.uogames.longProject.R

class MainActivityHW2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw2)

        findViewById<Button>(R.id.hw2_open_flags).setOnClickListener { startActivity(Intent(this, FlagsActivityHW2::class.java))}

        findViewById<Button>(R.id.hw2_open_flags_v2).setOnClickListener { startActivity(Intent(this, FlagsV2ActivityHW2::class.java)) }

        findViewById<Button>(R.id.hw2_open_animation).setOnClickListener { startActivity(Intent(this, AnimationActivityHW2::class.java)) }

    }
}