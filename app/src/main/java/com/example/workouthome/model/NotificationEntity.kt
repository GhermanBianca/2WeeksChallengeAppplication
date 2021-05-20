package com.example.workouthome.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class NotificationEntity {

    @PrimaryKey
    var userEmail : String = ""

    @ColumnInfo (name = "NOTIFICATION_STATUS")
    var wasActivated : Boolean = false
}