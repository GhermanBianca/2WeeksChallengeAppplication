package com.example.workouthome.repository

import androidx.lifecycle.LiveData
import com.example.workouthome.dao.NotificationDAO
import com.example.workouthome.model.NotificationEntity

class NotificationRepository(private val notificationDao: NotificationDAO) {

    val getAllData: LiveData<List<NotificationEntity>> = notificationDao.getAllData()

    fun getAllData() : LiveData<List<NotificationEntity>> {
        return notificationDao.getAllData()
    }

    suspend fun insertOrUpdate(notification: NotificationEntity) {
        notificationDao.insertOrUpdate(notification)
    }
}