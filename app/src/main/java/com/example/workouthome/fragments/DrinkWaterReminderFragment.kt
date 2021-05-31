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
import androidx.lifecycle.ViewModelProvider
import com.example.workouthome.R
import com.example.workouthome.databinding.FragmentDrinkWaterReminderBinding
import com.example.workouthome.firebase.FirebaseUtils
import com.example.workouthome.model.NotificationEntity
import com.example.workouthome.model.NotificationViewModel
import com.example.workouthome.reminder.NotificationReciever

class DrinkWaterReminderFragment : Fragment(R.layout.fragment_drink_water_reminder) {

    private var _binding: FragmentDrinkWaterReminderBinding? = null
    private val binding get() = _binding!!
    private lateinit var mNotificationViewModel: NotificationViewModel
    private var wasActivated = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDrinkWaterReminderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNotificationViewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)

        Log.d(TAG, "Before click on btnStartAlarm: $wasActivated ")

        val currentId = FirebaseUtils.getCurrentUserId()


        _binding?.btnStartAlarm?.setOnClickListener {
            startAlarm()
            _binding?.descriptionStatusTv?.text = getString(R.string.add_notification_description)
            wasActivated = true
            Log.d(TAG, "btnStartAlarm: $wasActivated ")

            Log.d(TAG, "btnStartAlarm Current user : $currentId")

            val notificationEntity = NotificationEntity(
                currentId,
                wasActivated,
                getString(R.string.add_notification_description)
            )

            insertOrUpdate(notificationEntity)
        }

        _binding?.btnStopAlarm?.setOnClickListener {
            cancelAlarm()
            _binding?.descriptionStatusTv?.text = ""
            wasActivated = false
            Log.d(TAG, "btnStopAlarm: $wasActivated ")

            @Suppress("NAME_SHADOWING") val currentId = FirebaseUtils.getCurrentUserId()
            Log.d(TAG, "btnStopAlarm Current user : $currentId")


            val notificationEntity = NotificationEntity(currentId, wasActivated, "")

            insertOrUpdate(notificationEntity)
        }

        getDataFromDatabase(currentId)
    }

    private fun insertOrUpdate(currentUser: NotificationEntity) {
        mNotificationViewModel.insertOrUpdate(currentUser)
    }

    private fun getDataFromDatabase(currentId: String) {

        mNotificationViewModel.getAllData().observe(viewLifecycleOwner, { it ->
            Log.d(TAG, "List from database  -> $it")

            if (it.isEmpty()) {
                Log.d(TAG, "List is empty")

                return@observe
            }

            it.forEach {
                if (it.userId == currentId) {
                    val firstItemDescription = it.notificationDescription
                    Log.d(TAG, "firstItemDescription -> $firstItemDescription")
                    val wasActivated = it.wasActivated
                    if (wasActivated) {
                        _binding?.descriptionStatusTv?.text = firstItemDescription
                    }
                }
            }
        })
    }

    @SuppressLint("ShortAlarm")
    fun startAlarm() {
        val alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(context?.applicationContext, NotificationReciever::class.java)
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

    companion object {
        private const val TAG = "DrinkWaterReminderFragment"
    }
}