package com.example.workouthome.fragments

import android.app.*
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentDrinkWaterReminderBinding
import com.example.workouthome.utils.NotificationReciever


class DrinkWaterReminder : Fragment(R.layout.fragment_drink_water_reminder) {

    private var _binding: FragmentDrinkWaterReminderBinding? = null
    private val binding get() = _binding!!
    private lateinit var alarmManager: AlarmManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDrinkWaterReminderBinding.inflate(inflater, container, false)
        //alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.btnStartAlarm?.setOnClickListener {
            startAlarm()
        }

        _binding?.btnStopAlarm?.setOnClickListener {
            cancelAlarm()
        }
    }

    fun startAlarm() {
        val alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(
            context?.getApplicationContext(), NotificationReciever::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0)
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 3000, pendingIntent)
        Log.d("ME", "Alarm started")
    }

    fun cancelAlarm() {
        val alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(
            context?.getApplicationContext(), NotificationReciever::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 0)
        alarmManager.cancel(pendingIntent)
        Toast.makeText(context, "Alarm Canceled", Toast.LENGTH_SHORT).show()
    }
}