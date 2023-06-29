package com.linhpham.baseproject.data.user.di

import com.linhpham.baseproject.data.AppDataDatabase
import com.linhpham.baseproject.data.user.datasource.LocalUserDataSource
import com.linhpham.baseproject.data.user.datasource.RemoteUserDataSource
import com.linhpham.baseproject.data.user.repository.UserRepository
import com.linhpham.baseproject.data.utils.ApiClient
import com.linhpham.baseproject.data.utils.Session
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserModule {
    @Provides
    @Singleton
    fun provideLocalUserDataSource(
        database: AppDataDatabase
    ) : LocalUserDataSource = LocalUserDataSource(database.userDao())

    @Provides
    @Singleton
    fun provideRemoteUserDataSource(apiClient: ApiClient): RemoteUserDataSource =
        RemoteUserDataSource(apiClient)

    @Provides
    @Singleton
    fun provideUserRepository(
        session: Session,
        localDataSource: LocalUserDataSource,
        remoteDataSource: RemoteUserDataSource,

    ): UserRepository =
        UserRepository(session,localDataSource,remoteDataSource)
}
