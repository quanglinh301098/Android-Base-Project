package com.linhpham.goodnight.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.linhpham.goodnight.data.alarm.dao.AlarmDao
import com.linhpham.goodnight.data.alarm.entity.Alarm
import com.linhpham.goodnight.data.user.dao.UserDao
import com.linhpham.goodnight.data.user.entity.User
import com.linhpham.goodnight.data.utils.Converters

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
