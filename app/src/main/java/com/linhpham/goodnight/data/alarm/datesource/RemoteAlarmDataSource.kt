package com.linhpham.goodnight.data.alarm.datesource

import com.linhpham.goodnight.base.BaseRemoteDataSource
import com.linhpham.goodnight.data.alarm.entity.Alarm
import com.linhpham.goodnight.data.utils.ApiClient

class RemoteAlarmDataSource(apiClient: ApiClient) : BaseRemoteDataSource<Alarm>(apiClient) {
    override suspend fun submitData(items: List<Alarm>) {
        TODO()
    }

    override suspend fun getDataFromServer(): List<Alarm> {
        TODO()
    }
}