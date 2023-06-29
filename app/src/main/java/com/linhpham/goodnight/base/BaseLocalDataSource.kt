package com.linhpham.goodnight.base

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

/**
 * Created by Habbot Phan on 10/14/2022.
 **/
interface BaseLocalDataSource<T : BaseModel> {
    fun getAllAvailableData(): Flow<List<T>>
    suspend fun getAllData(): List<T>
    suspend fun bulkInsert(items: List<T>)
    suspend fun insert(item: T)
    suspend fun update(item: T)

    suspend fun getUpdatedData(): List<T>
    suspend fun delete(id: String)
    suspend fun remove(id: String)

    fun getById(id: String): Flow<T>

    fun getByUserId(userId:String):Flow<List<T>>
}
