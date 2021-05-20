package com.example.workouthome.roomdb

import androidx.room.RoomDatabase

abstract class NotificationDB : RoomDatabase(){

    abstract fun notificationDAO() : NotificationDAO
}