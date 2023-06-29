package com.linhpham.goodnight.data.user.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.linhpham.goodnight.data.user.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (vararg user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkInsert (users:List<User>)

    @Update
    suspend fun update (vararg user: User)

    @Delete
    suspend fun delete (vararg user: User)

    @Query("SELECT * FROM `user` WHERE isDeleted=0")
    fun getAllAvailableUsers(): Flow<List<User>>

    @Query("SELECT * FROM `user` WHERE isDeleted=0")
    suspend fun getAllAvailableUsersOnce(): List<User>

    @Query("SELECT * FROM `user` WHERE id=:id")
    fun getUserById(id:String): Flow<User>

    @Query("SELECT * FROM `user` WHERE id=:id")
    suspend fun getUserByIdOnce(id:String): User
}