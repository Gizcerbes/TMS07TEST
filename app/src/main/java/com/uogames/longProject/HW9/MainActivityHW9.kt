package com.uogames.longProject.HW9

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModelProvider
import com.uogames.longProject.App
import com.uogames.longProject.MainActivity
import com.uogames.longProject.R

class MainActivityHW9 : AppCompatActivity() {
    companion object {
        const val ADVICE = "advice"
    }

    private val viewModel by lazy { ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModelHW9::class.java) }

    lateinit var startBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw9)

        val text = findViewById<TextView>(R.id.text_hw9)

        viewModel.time.observe(this){
            text.text = it.toString()
        }

        viewModel.advice.observe(this) {
            val intent = Intent(this, ForegroundServiceHW9::class.java).apply {
                putExtra(ADVICE, it.advice)
            }
            startService(intent)
            text.text = ""
        }

       startBtn = findViewById<Button>(R.id.start_notification).apply {
            setOnClickListener {
                viewModel.loadAdvice()
            }
        }
    }
}