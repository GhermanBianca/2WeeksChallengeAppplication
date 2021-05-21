package com.example.workouthome.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workouthome.model.NotificationEntity

@Dao
interface NotificationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNotification( notification : NotificationEntity)

    @Query("SELECT * FROM notification_table")
    fun getAllData() : LiveData<List<NotificationEntity>>

}