package com.linhpham.baseproject.data.user.repository

import com.linhpham.baseproject.base.BaseRepository
import com.linhpham.baseproject.data.user.datasource.LocalUserDataSource
import com.linhpham.baseproject.data.user.datasource.RemoteUserDataSource
import com.linhpham.baseproject.data.user.entity.LoginResponse
import com.linhpham.baseproject.data.user.entity.User
import com.linhpham.baseproject.data.utils.Session
import kotlinx.coroutines.flow.Flow


class UserRepository(
    val session: Session,
    localDataSource: LocalUserDataSource,
    override val remoteDataSource: RemoteUserDataSource
) : BaseRepository<User>(session, localDataSource, remoteDataSource) {
    suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    suspend fun login(data: User): User {
        val response = remoteDataSource.login(data)
        session.accessToken = response.token
        session.currentUserId = response.data.id
        return response.data
    }

}



