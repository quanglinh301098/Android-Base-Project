package com.linhpham.goodnight.data.user.datasource

import com.linhpham.goodnight.base.BaseRemoteDataSource
import com.linhpham.goodnight.data.user.entity.User
import com.linhpham.goodnight.data.utils.ApiClient
import com.linhpham.goodnight.data.utils.BaseResponse
import javax.inject.Inject


class RemoteUserDataSource (apiClient: ApiClient) : BaseRemoteDataSource<User>(apiClient) {

    override suspend fun submitData(items: List<User>)  {

    }
    override suspend fun getDataFromServer(): List<User> {
        TODO("Not yet implemented")
    }
}
