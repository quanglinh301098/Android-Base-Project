package com.linhpham.goodnight.data.utils

import com.linhpham.goodnight.BuildConfig
import com.linhpham.goodnight.data.auth.entity.RefreshTokenResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 *  Adds the Authorization: header to retrofit HTTP requests and refresh token if it's expired
 */

class AuthorizationInterceptor(private val session: Session) : Interceptor {

    //region Interceptor

    override fun intercept(chain: Interceptor.Chain): Response {
        val key = session.accessToken
        val credentials = if (key.isNullOrEmpty()) "" else String.format("Bearer %s", key)

        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", credentials)
            .build()

        val response = chain.proceed(request)

        if (response.code == 401 && !session.accessToken.isNullOrEmpty()) {
            val token = getNewToken()
            return if (token == null) {
                response
            } else {
                // Refresh token if it's expired
                session.accessToken = token.token
                response.close()
                val newRequest = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", String.format("Bearer %s", token.token))
                    .build()
                val response2 = chain.proceed(newRequest)

                response2
            }
        } else {

            return response
        }

    }

    private fun getNewToken(): RefreshTokenResponse? {
        val call = Retrofit.Builder().baseUrl(BuildConfig.API_URL)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
            .create(ApiClient::class.java)
            .refreshToken(String.format("Bearer %s", session.accessToken.orEmpty()))
        return call.execute().body()
    }

    //endregion

}
