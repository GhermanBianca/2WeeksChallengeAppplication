package com.example.workouthome.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.workouthome.model.NotificationEntity

@Dao
interface NotificationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNotification( notification : NotificationEntity)

//    @Query( "select * from NotificationEntity")
//    fun readNotification() : List<NotificationEntity>
}