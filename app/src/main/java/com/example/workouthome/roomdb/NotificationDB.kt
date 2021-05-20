package com.example.workouthome.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workouthome.dao.NotificationDAO
import com.example.workouthome.model.NotificationEntity

@Database (entities = [(NotificationEntity::class)], version = 1)
abstract class NotificationDB : RoomDatabase(){

    abstract fun notificationDAO() : NotificationDAO
}