package com.linhpham.baseproject.base

import kotlinx.coroutines.flow.Flow

interface BaseLocalDataSource<T : BaseModel> {
    fun getAllAvailableData(): Flow<List<T>>
    suspend fun getAllData(): List<T>
    suspend fun bulkInsert(items: List<T>)
    suspend fun insert(item: T)
    suspend fun update(item: T)

    suspend fun getUpdatedData(): List<T>
    suspend fun delete(id: String)

    fun getById(id: String): Flow<T>

    fun getByUserId(userId:String):Flow<List<T>>
}
