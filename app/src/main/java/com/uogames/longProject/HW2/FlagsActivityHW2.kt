package com.uogames.longProject.HW2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.uogames.longProject.R

class FlagsActivityHW2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags_hw2)

        val flagArmenia = findViewById<ImageView>(R.id.hw2_flag_armenia)
        val flagAustria = findViewById<ImageView>(R.id.hw2_flag_austria)
        val flagBelgium = findViewById<ImageView>(R.id.hw2_flag_belgium)
        val flagLatvia = findViewById<ImageView>(R.id.hw2_flag_latvia)
        val flagDenmark = findViewById<ImageView>(R.id.hw2_flag_denmark)
        val flagSpain = findViewById<ImageView>(R.id.hw2_flag_spain)

        Picasso.get().load(getString(R.string.Link_flag_armenia)).into(flagArmenia)
        Picasso.get().load(getString(R.string.Link_flag_austria)).into(flagAustria)
        Picasso.get().load(getString(R.string.Link_flag_belgium)).into(flagBelgium)
        Picasso.get().load(getString(R.string.Link_flag_latvia)).into(flagLatvia)
        Picasso.get().load(getString(R.string.Link_flag_denmark)).into(flagDenmark)
        Picasso.get().load(getString(R.string.Link_flag_spain)).into(flagSpain)



    }
}