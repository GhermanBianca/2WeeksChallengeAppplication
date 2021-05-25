@file:Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")

package com.example.workouthome.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.workouthome.firebase.FirebaseUtils
import com.example.workouthome.model.NotificationEntity

@Dao
interface NotificationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotification( notification : NotificationEntity)

    @Query("SELECT * FROM notification_table")
    fun getAllData() : LiveData<List<NotificationEntity>>

    @Query("SELECT * from notification_table WHERE userId= :currentUserId")
    fun getItemById(currentUserId: String) : List<NotificationEntity>

    @Query("UPDATE notification_table SET wasActivated =:wasActivated, notificationDescription =:notificationDescription WHERE userId = :currentUserId")
    fun updateNotification(wasActivated :Boolean, notificationDescription : String, currentUserId: String)

    suspend fun insertOrUpdate(notification: NotificationEntity) {
        val currentId = FirebaseUtils.getCurrentUserId()
        val notificationFromDB:List<NotificationEntity> = getItemById(currentId)
        if(notificationFromDB.contains(currentId)) {
            updateNotification(notification.wasActivated, notification.notificationDescription, currentId)
        } else {
            insertNotification(notification)
        }
    }
}
