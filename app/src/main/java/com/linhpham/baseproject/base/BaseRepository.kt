package com.linhpham.baseproject.base

import com.linhpham.baseproject.data.utils.Session
import kotlinx.coroutines.flow.Flow
import java.util.*

abstract class BaseRepository<T : BaseModel>(
    private val session: Session,
    open val localDataSource: BaseLocalDataSource<T>,
    open val remoteDataSource: BaseRemoteDataSource<T>
) {
    suspend fun getAllAvailableData(): Flow<List<T>> = localDataSource.getAllAvailableData()

    suspend fun getAllData(): List<T> = localDataSource.getAllData()

    suspend fun bulkInsert(items: List<T>) = localDataSource.bulkInsert(items)

    open suspend fun insert(item: T) {
        localDataSource.insert(item)
    }

    suspend fun update(item: T) {
        localDataSource.update(item)
    }

    open suspend fun delete(item: T) {
        localDataSource.delete(item.id)
    }

    suspend fun getUpdatedData(): List<T> = localDataSource.getUpdatedData()

    fun getById(id: String): Flow<T> = localDataSource.getById(id)

}
