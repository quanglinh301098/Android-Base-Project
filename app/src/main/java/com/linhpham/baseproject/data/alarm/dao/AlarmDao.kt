package com.linhpham.baseproject.data.alarm.dao

import androidx.room.*
import com.linhpham.baseproject.data.alarm.entity.Alarm
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface AlarmDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkInsert(items: List<Alarm>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Alarm)

    @Query("SELECT * FROM Alarm ")
    fun getAllAvailableData(): Flow<List<Alarm>>

    @Delete
    suspend fun delete(item : Alarm)

    @Update
    suspend fun updateAlarm(item: Alarm)


    @Query("SELECT * FROM  Alarm WHERE id=:id")
    fun getById(id: String): Flow<Alarm>

    @Query("DELETE FROM  Alarm WHERE id=:id")
    suspend fun remove(id: String)

    @Query("SELECT COUNT(*) FROM Alarm")
    suspend fun getCategoryCount(): Long

    @Transaction
    @Query("SELECT * FROM Alarm ")
    fun getAlarms(): Flow<List<Alarm>>

    @Query("SELECT  * FROM Alarm WHERE (\"\"=:userId OR userId=:userId)")
    fun getByUserId(userId: String): Flow<List<Alarm>>


}