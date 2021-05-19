package com.example.workouthome.roomdb

import androidx.room.Entity

@Entity
class NotificationEntity {

    var userEmail : String = ""
    var wasActivated : Boolean = false
}