package com.linhpham.goodnight.data.user.datasource

import com.linhpham.goodnight.base.BaseLocalDataSource
import com.linhpham.goodnight.data.user.dao.UserDao
import com.linhpham.goodnight.data.user.entity.User
import kotlinx.coroutines.flow.Flow

class LocalUserDataSource (private val dao : UserDao) : BaseLocalDataSource<User> {
    override fun getAllAvailableData(): Flow<List<User>> = dao.getAllAvailableUsers()

    override suspend fun bulkInsert(items: List<User>) = dao.bulkInsert(items)

    override suspend fun insert(item: User) = dao.insert(item)

    override suspend fun update(item: User) = dao.update(item)

    suspend fun delete(item: User)= dao.delete(item)

    override suspend fun getAllData(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUpdatedData(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun remove(id: String) {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): Flow<User> {
        TODO("Not yet implemented")
    }

    override fun getByUserId(userId: String): Flow<List<User>> {
        TODO("Not yet implemented")
    }

}