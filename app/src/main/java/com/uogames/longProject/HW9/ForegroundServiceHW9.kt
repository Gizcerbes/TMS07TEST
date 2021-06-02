package com.uogames.longProject.HW9

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.uogames.longProject.App
import com.uogames.longProject.MainActivity
import com.uogames.longProject.R

class ForegroundServiceHW9 : Service() {


    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val contentIntent = PendingIntent.getService(
            this,
            0,
            Intent(this, AdviceService::class.java).apply {
                putExtra(MainActivityHW9.ADVICE, intent?.getStringExtra(MainActivityHW9.ADVICE))
            },
            0,
        )

        val notification = NotificationCompat.Builder(this, App.NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Telegram message")
            .setContentText("There is a new tip")
            .setSmallIcon(R.drawable.ic_baseline_search_24)
            .setContentIntent(contentIntent)
            .addAction(
                R.drawable.ic_baseline_search_24,
                "Open",
                contentIntent
            )
            .build()

        startForeground(1, notification)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}