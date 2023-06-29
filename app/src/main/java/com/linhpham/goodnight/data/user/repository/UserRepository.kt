package com.linhpham.goodnight.data.user.repository

import com.linhpham.goodnight.base.BaseRepository
import com.linhpham.goodnight.data.alarm.entity.Alarm
import com.linhpham.goodnight.data.user.datasource.LocalUserDataSource
import com.linhpham.goodnight.data.user.datasource.RemoteUserDataSource
import com.linhpham.goodnight.data.user.entity.User
import com.linhpham.goodnight.data.utils.Session
import kotlinx.coroutines.flow.Flow


class UserRepository(
    session: Session,
    localDataSource: LocalUserDataSource,
    remoteDataSource: RemoteUserDataSource
) : BaseRepository<User>(session, localDataSource, remoteDataSource) {
    suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    suspend fun remove(id: String) {
        localDataSource.remove(id)
    }

    suspend fun getByUserId(userId: String): Flow<List<User>> {
        return  localDataSource.getByUserId(userId)
    }


}



