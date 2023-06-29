package com.linhpham.goodnight.data.alarm.datesource

import com.linhpham.goodnight.base.BaseLocalDataSource
import com.linhpham.goodnight.data.alarm.dao.AlarmDao
import com.linhpham.goodnight.data.alarm.entity.Alarm
import kotlinx.coroutines.flow.Flow

class LocalAlarmDataSource(private val alarmDao: AlarmDao) : BaseLocalDataSource<Alarm> {
    override fun getAllAvailableData(): Flow<List<Alarm>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllData(): List<Alarm> {
        TODO("Not yet implemented")
    }

    override suspend fun bulkInsert(items: List<Alarm>) {
        TODO("Not yet implemented")
    }

    override suspend fun insert(item: Alarm) {
        TODO("Not yet implemented")
    }

    override suspend fun update(item: Alarm) {
        TODO("Not yet implemented")
    }

    override suspend fun getUpdatedData(): List<Alarm> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun remove(id: String) {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): Flow<Alarm> {
        TODO("Not yet implemented")
    }

    override fun getByUserId(userId: String): Flow<List<Alarm>> {
        TODO("Not yet implemented")
    }
}