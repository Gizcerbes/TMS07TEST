package com.uogames.longProject.HW9

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import com.uogames.longProject.App
import com.uogames.longProject.R

class MainActivityHW9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw9)

        findViewById<Button>(R.id.start_notification).setOnClickListener {

            val contentIntent = PendingIntent.getActivity(
                this, 999,
                Intent(this, MainActivityHW9::class.java),
                PendingIntent.FLAG_CANCEL_CURRENT
            )

            val notification = NotificationCompat.Builder(this, App.NOTIFICATION_CHANNEL_ID)
                .setContentTitle("Telegram message")
                .setContentText("Не пиши сюда больше!!")
                //.setSmallIcon(R.drawable.ic_baseline_bike_scooter_24)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setPriority(2)
                .addAction(
                    R.drawable.ic_baseline_search_24,
                    "Open Main",
                    contentIntent
                )
                .build()

            val manager = getSystemService(NotificationManager::class.java)
            manager.notify(1, notification)

        }
    }
}