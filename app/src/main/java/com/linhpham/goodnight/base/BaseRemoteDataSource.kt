package com.linhpham.goodnight.base

import com.linhpham.goodnight.data.utils.ApiClient

/**
 * Created by Habbot Phan on 10/14/2022.
 **/
abstract class BaseRemoteDataSource<T : BaseModel>(
    protected val apiClient: ApiClient
) {
    abstract suspend fun submitData(items: List<T>)
    abstract suspend fun getDataFromServer(): List<T>
}
