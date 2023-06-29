package com.linhpham.goodnight.data.utils

import com.linhpham.goodnight.data.auth.entity.RefreshTokenResponse
import com.linhpham.goodnight.data.user.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {
    @GET("/public/v1/users")
    suspend fun getUsers(@Query("page") page: Int): BaseResponse<List<User>>

    @POST("/refresh-token")
    fun refreshToken(@Header("Authorization") bearerToken: String): Call<RefreshTokenResponse>

}
