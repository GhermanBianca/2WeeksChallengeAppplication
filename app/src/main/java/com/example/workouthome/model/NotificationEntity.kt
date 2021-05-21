package com.example.workouthome.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notification_table")
data class NotificationEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId: String,
    val wasActivated: Boolean,
    val notificationDescription: String
)