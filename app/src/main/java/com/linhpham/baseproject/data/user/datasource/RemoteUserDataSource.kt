package com.linhpham.baseproject.data.user.datasource

import com.linhpham.baseproject.base.BaseRemoteDataSource
import com.linhpham.baseproject.data.user.entity.User
import com.linhpham.baseproject.data.utils.ApiClient


class RemoteUserDataSource (apiClient: ApiClient) : BaseRemoteDataSource<User>(apiClient) {
    suspend fun login(data: User) = apiClient.login(data)

}
