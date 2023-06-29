package com.linhpham.goodnight.data.alarm.di

import com.linhpham.goodnight.data.AppDataDatabase
import com.linhpham.goodnight.data.alarm.datesource.LocalAlarmDataSource
import com.linhpham.goodnight.data.alarm.datesource.RemoteAlarmDataSource
import com.linhpham.goodnight.data.alarm.entity.Alarm
import com.linhpham.goodnight.data.alarm.repository.AlarmRepository
import com.linhpham.goodnight.data.user.datasource.LocalUserDataSource
import com.linhpham.goodnight.data.utils.ApiClient
import com.linhpham.goodnight.data.utils.Session
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AlarmModule {
    @Provides
    @Singleton
    fun provideLocalAlarmDataSource(
        database: AppDataDatabase
    ): LocalAlarmDataSource = LocalAlarmDataSource(database.alarmDao())

    @Provides
    @Singleton
    fun provideRemoteAlarmDataSource(
        apiClient: ApiClient
    ): RemoteAlarmDataSource = RemoteAlarmDataSource(apiClient)


    @Provides
    @Singleton
    fun provideAlarmRepository(
        session: Session,
        localAlarmDataSource: LocalAlarmDataSource,
        remoteAlarmDataSource: RemoteAlarmDataSource
    ): AlarmRepository = AlarmRepository(session, localAlarmDataSource, remoteAlarmDataSource)
}