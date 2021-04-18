package com.uogames.longProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.uogames.longProject.HW1.MainActivityHW1
import com.uogames.longProject.HW2.MainActivityHW2
import com.uogames.longProject.HW3.MainActivityHW3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener { startActivity(Intent(this, MainActivityHW1::class.java)) }
        findViewById<Button>(R.id.button2).setOnClickListener { startActivity(Intent(this, MainActivityHW2::class.java)) }
        findViewById<Button>(R.id.button3).setOnClickListener { startActivity(Intent(this, MainActivityHW3::class.java)) }
    }
}