package com.linhpham.baseproject.data.utils

import com.linhpham.baseproject.data.auth.entity.RefreshTokenResponse
import com.linhpham.baseproject.data.user.entity.LoginResponse
import com.linhpham.baseproject.data.user.entity.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {
    @GET("/public/v1/users")
    suspend fun getUsers(@Query("page") page: Int): BaseResponse<List<User>>

    @GET("/public/v1/users")
    suspend fun login(@Body data: User): LoginResponse

    @POST("/refresh-token")
    fun refreshToken(@Header("Authorization") bearerToken: String): Call<RefreshTokenResponse>

}
