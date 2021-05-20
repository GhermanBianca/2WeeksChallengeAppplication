package com.example.workouthome.fragments

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentDrinkWaterReminderBinding
import com.example.workouthome.reminder.NotificationReciever
import com.example.workouthome.roomdb.NotificationDB
import com.example.workouthome.roomdb.NotificationEntity

class DrinkWaterReminderFragment : Fragment(R.layout.fragment_drink_water_reminder) {

    companion object {
        private const val TAG = "DrinkWaterReminderFragment"
    }

    private var _binding: FragmentDrinkWaterReminderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDrinkWaterReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btnStartAlarm?.setOnClickListener {
            startAlarm()
            _binding?.descriptionStatusTv?.text = getString(R.string.add_notification_description)
        }

        _binding?.btnStopAlarm?.setOnClickListener {
            cancelAlarm()
            _binding?.descriptionStatusTv?.text = ""
        }


        val db = context?.let { Room.databaseBuilder(it.applicationContext, NotificationDB::class.java, "NotificationDB").build() }
        Thread {
            val notification = NotificationEntity()
            notification.userEmail = "bia@yahoo.com"
            notification.wasActivated = true

            Log.d(TAG, " db $db" )
            Log.d(TAG, " db db?.notificationDAO() ${db?.notificationDAO()} " )


            db?.notificationDAO()?.saveNotification(notification)

           /* db?.notificationDAO()?.readNotification()?.forEach {
                Log.i(TAG, "User email is ${it.userEmail}")
                Log.i(TAG, "Notification Status ${it.wasActivated}")
            }*/

        }.start()
    }

    @SuppressLint("ShortAlarm")
    fun startAlarm() {
        val alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(
            context?.applicationContext, NotificationReciever::class.java
        )
        val pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            1000 * 60 * 15,
            pendingIntent
        )
        Toast.makeText(context, getString(R.string.toast_start_notification), Toast.LENGTH_SHORT)
            .show()
    }

    private fun cancelAlarm() {
        val alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(
            context?.applicationContext, NotificationReciever::class.java
        )
        val pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0)
        alarmManager.cancel(pendingIntent)
        Toast.makeText(context, getString(R.string.toast_stop_notification), Toast.LENGTH_SHORT)
            .show()
    }
}