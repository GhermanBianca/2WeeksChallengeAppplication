package com.example.workouthome.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotificationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNotification( notification : NotificationEntity)

   /* @Query( "select * from NotificationEntity")
    fun readNotification() : List<NotificationEntity>*/
}