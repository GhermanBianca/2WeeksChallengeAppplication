package com.example.workouthome.repository

import android.app.Notification
import androidx.lifecycle.LiveData
import com.example.workouthome.dao.NotificationDAO
import com.example.workouthome.model.NotificationEntity

class NotificationRepository(private val notificationDao: NotificationDAO) {

    val getAllData: LiveData<List<NotificationEntity>> = notificationDao.getAllData()

    suspend fun insertNotification(notification: NotificationEntity) {
        notificationDao.insertNotification(notification)
    }

}