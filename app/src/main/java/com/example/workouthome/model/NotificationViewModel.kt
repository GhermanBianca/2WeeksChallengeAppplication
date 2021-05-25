package com.example.workouthome.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.workouthome.repository.NotificationRepository
import com.example.workouthome.roomdb.NotificationDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationViewModel(application: Application) : AndroidViewModel(application) {
    private val getAllData: LiveData<List<NotificationEntity>>
    private val repository: NotificationRepository

    init {
        val notificationDao = NotificationDB.getDatabase(application).notificationDAO()
        repository = NotificationRepository(notificationDao)
        getAllData = repository.getAllData
    }

    fun checkData(): LiveData<List<NotificationEntity>> {
        return repository.getAllData()
    }

    fun insertOrUpdate(notification: NotificationEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertOrUpdate(notification)
        }
    }
}