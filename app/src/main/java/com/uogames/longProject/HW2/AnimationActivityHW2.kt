package com.uogames.longProject.HW2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.uogames.longProject.R
import kotlinx.coroutines.*
import java.util.*

class AnimationActivityHW2 : AppCompatActivity() {
    var start = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_hw2)

        val imageView = findViewById<ImageView>(R.id.hw2_animation)
        val queue: Queue<Int> = getImageQueue()
        fetchQueue(queue)

        CoroutineScope(Dispatchers.Main).launch {
            start = true
            while (start) {
                val img = queue.poll()
                img?.let { Picasso.get().load(it).into(imageView) }
                delay(1000)
                queue.add(img)
            }
        }
    }

    override fun onDestroy() {
        start = false
        super.onDestroy()
    }

    fun getImageQueue(): Queue<Int> {
        val queue: Queue<Int> = LinkedList()
        queue.add(R.drawable.img0)
        queue.add(R.drawable.img1)
        queue.add(R.drawable.img0)
        queue.add(R.drawable.img3)
        return queue
    }

    fun fetchQueue(q: Queue<Int>) {
        q.forEach { Picasso.get().load(it).fetch() }
    }

}