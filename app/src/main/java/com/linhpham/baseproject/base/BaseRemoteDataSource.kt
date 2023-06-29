package com.linhpham.baseproject.base

import com.linhpham.baseproject.data.utils.ApiClient


abstract class BaseRemoteDataSource<T : BaseModel>(
    protected val apiClient: ApiClient
) {


}
