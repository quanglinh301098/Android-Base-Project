package com.linhpham.baseproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.linhpham.baseproject.data.alarm.dao.AlarmDao
import com.linhpham.baseproject.data.alarm.entity.Alarm
import com.linhpham.baseproject.data.user.dao.UserDao
import com.linhpham.baseproject.data.user.entity.User
import com.linhpham.baseproject.data.utils.Converters

// Annotates class to be a Room Database with a tables (entities)
@Database(
    entities = [User::class,Alarm::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDataDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun alarmDao(): AlarmDao

}
