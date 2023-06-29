package com.linhpham.goodnight.base

import androidx.lifecycle.LiveData
import com.linhpham.goodnight.data.utils.Session
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
        if (item.userId.isEmpty()) {
            item.userId = session.currentUserId
        }
        localDataSource.insert(item)
    }

    suspend fun update(item: T) {
        item.isSynced = false
        item.modifiedDate = Date().time / 1000.0
        localDataSource.update(item)
    }

    open suspend fun delete(item: T) {
        if (item.isSyncedFlag) {
            localDataSource.delete(item.id)
        } else {
            localDataSource.remove(item.id)
        }
    }

    suspend fun getUpdatedData(): List<T> = localDataSource.getUpdatedData()

    fun getById(id: String): Flow<T> = localDataSource.getById(id)

    suspend fun submitData(items: List<T>) = remoteDataSource.submitData(items)

    suspend fun getDataFromServer(): List<T> {
        val data = remoteDataSource.getDataFromServer()
        val date = Date().time
        localDataSource.bulkInsert(data)
        session.lastSyncWalletDate = date
        return data
    }
}
