package com.uogames.longProject.HW1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.uogames.longProject.R

class MainActivityHW1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_h_w1)

        val myUrl = findViewById<EditText>(R.id.hw1_Edit)
        val imageView = findViewById<ImageView>(R.id.hw1_my_Image)
        val loadButton = findViewById<Button>(R.id.hw1_load_image)
        val openCanvas = findViewById<Button>(R.id.hw1_canvas)

        loadButton.setOnClickListener {
            Glide.with(this)
                .load(myUrl.text.toString().orEmpty())
                .into(imageView)
        }
        openCanvas.setOnClickListener {
            startActivity(Intent(this, SecondActivityHW1::class.java))
        }

    }
}