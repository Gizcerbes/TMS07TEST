package com.uogames.longProject.HW3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.uogames.longProject.R

class MainActivityHW3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw3)


    }

    fun loadCreast(){
        val crestMinsk = findViewById<ImageView>(R.id.hw3_crest_Minsk)
        val crestViciebsk = findViewById<ImageView>(R.id.hw3_crest_Viciebsk)
        val crestHrodna = findViewById<ImageView>(R.id.hw3_crest_Hrodna)
        val crestBrest = findViewById<ImageView>(R.id.hw3_crest_Brest)
        val crestHomiel = findViewById<ImageView>(R.id.hw3_crest_Homiel)
        val crestMahilo = findViewById<ImageView>(R.id.hw3_crest_Mahilo)

        Picasso.get().load(getString(R.string.Link_crest_Minsk)).into(crestMinsk)
        Picasso.get().load(getString(R.string.Link_crest_Viciebsk)).into(crestViciebsk)
        Picasso.get().load(getString(R.string.Link_crest_Hrodna)).into(crestHrodna)
        Picasso.get().load(getString(R.string.Link_crest_Brest)).into(crestBrest)
        Picasso.get().load(getString(R.string.Link_crest_Homiel)).into(crestHomiel)
        Picasso.get().load(getString(R.string.Link_crest_Mahilo)).into(crestMahilo)

    }

}