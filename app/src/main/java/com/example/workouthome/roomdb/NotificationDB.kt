package com.example.workouthome.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workouthome.dao.NotificationDAO
import com.example.workouthome.model.NotificationEntity

@Database (entities = [(NotificationEntity::class)], version = 1, exportSchema = false)
abstract class NotificationDB : RoomDatabase(){

    abstract fun notificationDAO() : NotificationDAO

    companion object{
        @Volatile
        private var INSTANCE: NotificationDB? = null

        fun getDatabase(context: Context) : NotificationDB {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotificationDB::class.java,
                    "notification_db"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}