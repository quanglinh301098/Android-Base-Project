package com.linhpham.baseproject.data.alarm.di

import com.linhpham.baseproject.data.AppDataDatabase
import com.linhpham.baseproject.data.alarm.datesource.LocalAlarmDataSource
import com.linhpham.baseproject.data.alarm.datesource.RemoteAlarmDataSource
import com.linhpham.baseproject.data.alarm.repository.AlarmRepository
import com.linhpham.baseproject.data.utils.ApiClient
import com.linhpham.baseproject.data.utils.Session
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