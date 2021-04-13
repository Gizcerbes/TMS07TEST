package com.uogames.longProject.HW2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.uogames.longProject.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class AnimationActivityHW2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_hw2)

        val imageView = findViewById<ImageView>(R.id.hw2_animation)
        val queue: Queue<Int> = LinkedList()
        queue.add(R.drawable.img0)
        queue.add(R.drawable.img1)
        queue.add(R.drawable.img2)
        queue.add(R.drawable.img3)



        GlobalScope.launch {
            while (true) {
                val img = queue.poll()
                img?.let {
                    launch(Dispatchers.Main) {
                        Picasso.get().load(it).into(imageView)
                    }
                }
                delay(1000)
                queue.add(img)
            }
        }

    }
}