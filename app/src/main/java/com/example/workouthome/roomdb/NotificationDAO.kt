package com.example.workouthome.roomdb

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NotificationDAO {

    @Insert
    fun saveNotification( notification : NotificationEntity)
}