package com.linhpham.baseproject.data.alarm.repository

import com.linhpham.baseproject.base.BaseRepository
import com.linhpham.baseproject.data.alarm.datesource.LocalAlarmDataSource
import com.linhpham.baseproject.data.alarm.datesource.RemoteAlarmDataSource
import com.linhpham.baseproject.data.alarm.entity.Alarm
import com.linhpham.baseproject.data.utils.Session
import kotlinx.coroutines.flow.Flow

class AlarmRepository(
    session: Session,
    localAlarmDataSource: LocalAlarmDataSource,
    remoteAlarmDataSource: RemoteAlarmDataSource
) : BaseRepository<Alarm>(session, localAlarmDataSource, remoteAlarmDataSource) {
    suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

}