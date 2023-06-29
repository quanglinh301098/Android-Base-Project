package com.linhpham.baseproject.data.alarm.datesource

import com.linhpham.baseproject.base.BaseRemoteDataSource
import com.linhpham.baseproject.data.alarm.entity.Alarm
import com.linhpham.baseproject.data.utils.ApiClient

class RemoteAlarmDataSource(apiClient: ApiClient) : BaseRemoteDataSource<Alarm>(apiClient) {

}