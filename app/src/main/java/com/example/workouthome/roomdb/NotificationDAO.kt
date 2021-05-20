package com.example.workouthome.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotificationDAO {

    @Insert
    fun saveNotification( notification : NotificationEntity)

    @Query( "select * from NotificationEntity")
    fun readNotification() : List<NotificationEntity>
}