package com.linhpham.baseproject.data.user.entity

data class LoginResponse(
    val token:String,
    val refreshToken:String,
    val data: User,
)