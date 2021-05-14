package com.example.workouthome.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class NotificationReciever : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val notificationHelper = NotificationHelper(context)
        val nb: NotificationCompat.Builder? = notificationHelper.getChannelNotification()
        notificationHelper.manager!!.notify(1, nb?.build())
    }
}
