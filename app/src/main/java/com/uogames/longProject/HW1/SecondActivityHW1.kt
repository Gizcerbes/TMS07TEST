package com.uogames.longProject.HW1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.uogames.longProject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondActivityHW1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_h_w1)

        val myUrl = findViewById<EditText>(R.id.hw1_edit_pixel)
        val imageView = findViewById<ImageView>(R.id.hw1_my_canvas)
        val loadButton = findViewById<Button>(R.id.hw1_set_pixel)

        loadImage(imageView)

        loadButton.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val url = "http://93.125.42.151:8080/ImageStream?${myUrl.text.toString()}"

            val stringRequest = StringRequest(Request.Method.GET, url,
                {
                    loadImage(imageView)
                }, { })
            queue.add(stringRequest)
        }

//        loadButton.setOnClickListener {
//            Glide.with(this).load(myUrl.text.toString().orEmpty()).into(imageView)
//        }
    }

    fun loadImage(view: ImageView) {
        Glide.with(this).load("http://93.125.42.151:8080/ImageStream/image.jpeg").diskCacheStrategy(
            DiskCacheStrategy.NONE).skipMemoryCache(true).into(view)
    }
}