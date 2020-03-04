package com.bravedroid.playground.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bravedroid.playground.R
import kotlinx.android.synthetic.main.activity_notification_test.*

class NotificationTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_test)
        notification_test_btn.setOnClickListener {
            registerNotificationChannel()
            NewMessageNotification.notify(this, "Reminder", 1)
        }
    }

    fun registerNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = getSystemService((Context.NOTIFICATION_SERVICE)) as NotificationManager
            val channel = NotificationChannel(NewMessageNotification.channel1,
                    "Note Reminders",
                    NotificationManager.IMPORTANCE_DEFAULT)
            nm.createNotificationChannel(channel)
        }
    }
}
