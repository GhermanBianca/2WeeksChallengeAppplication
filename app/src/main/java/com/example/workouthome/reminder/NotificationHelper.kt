package com.example.workouthome.reminder

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.workouthome.R
import com.example.workouthome.activities.DrinkWaterActivity

class NotificationHelper(base: Context?) : ContextWrapper(base) {
    private var notificationManager: NotificationManager? = null
    @SuppressLint("RemoteViewLayout")
    val notificationLayoutExpanded = RemoteViews(packageName, R.layout.backround_notification)
    val manager: NotificationManager?
        get() {
            if (notificationManager == null) {
                notificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            return notificationManager
        }
    @TargetApi(Build.VERSION_CODES.O)
    private fun createChannel() {
        val channel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH)
        manager!!.createNotificationChannel(channel)
    }

    fun getChannelNotification(): NotificationCompat.Builder? {
        val intent = Intent(this, DrinkWaterActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 , intent,
            PendingIntent.FLAG_ONE_SHOT
        )
        return NotificationCompat.Builder(applicationContext, channelID)
            .setContentTitle(getString(R.string.drink_water_reminder))
            .setSmallIcon(R.drawable.ic_water)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setContent(notificationLayoutExpanded)
    }

    companion object {
        const val channelID = "channelID"
        const val channelName = "Channel Name"
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }
    }
}


