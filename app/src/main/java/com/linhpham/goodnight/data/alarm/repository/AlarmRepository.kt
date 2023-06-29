package com.linhpham.goodnight.data.alarm.repository

import com.linhpham.goodnight.base.BaseRepository
import com.linhpham.goodnight.data.alarm.datesource.LocalAlarmDataSource
import com.linhpham.goodnight.data.alarm.datesource.RemoteAlarmDataSource
import com.linhpham.goodnight.data.alarm.entity.Alarm
import com.linhpham.goodnight.data.utils.Session
import kotlinx.coroutines.flow.Flow

class AlarmRepository(
    session: Session,
    localAlarmDataSource: LocalAlarmDataSource,
    remoteAlarmDataSource: RemoteAlarmDataSource
) : BaseRepository<Alarm>(session, localAlarmDataSource, remoteAlarmDataSource) {
    suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    suspend fun remove(id: String) {
        localDataSource.remove(id)
    }

    suspend fun getByUserId(userId: String): Flow<List<Alarm>> {
      return localDataSource.getByUserId(userId)
    }

}