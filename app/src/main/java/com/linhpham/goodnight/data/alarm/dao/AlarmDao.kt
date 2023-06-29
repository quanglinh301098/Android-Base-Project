package com.linhpham.goodnight.data.alarm.dao

import androidx.room.*
import com.linhpham.goodnight.data.alarm.entity.Alarm
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface AlarmDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkInsert(items: List<Alarm>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Alarm)

    @Query("SELECT * FROM Alarm WHERE isDeleted=0")
    fun getAllAvailableData(): Flow<List<Alarm>>

    @Query("UPDATE Alarm SET isDeleted=1, modifiedDate=:date WHERE id=:planId")
    suspend fun delete(planId: String, date: Long = Date().time)

    @Query("SELECT * FROM Alarm WHERE isDeleted=0")
    suspend fun getAllIncomeCategories(): List<Alarm>

    @Update
    suspend fun updateAlarm(plan: Alarm)

    @Query("SELECT * FROM Alarm WHERE isSynced=0")
    suspend fun getUpdatedItems(): List<Alarm>

    @Query("SELECT * FROM  Alarm WHERE id=:id")
    fun getById(id: String): Flow<Alarm>

    @Query("DELETE FROM  Alarm WHERE id=:id")
    suspend fun remove(id: String)

    @Query("SELECT COUNT(*) FROM Alarm")
    suspend fun getCategoryCount(): Long

    @Transaction
    @Query("SELECT * FROM Alarm WHERE isDeleted=0")
    fun getAlarms(): Flow<List<Alarm>>

    @Query("SELECT  * FROM Alarm WHERE isDeleted=0 AND (\"\"=:userId OR userId=:userId)")
    fun getByUserId(userId: String): Flow<List<Alarm>>


}