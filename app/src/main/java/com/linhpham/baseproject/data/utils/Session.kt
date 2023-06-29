package com.linhpham.baseproject.data.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Session @Inject constructor(context: Context) {
    companion object {
        const val PREF_USER_ID = "user_id"
        const val PREF_DEVICE_ID = "device_id"
        const val PREF_ACCESS_TOKEN = "access_token"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(context.packageName + "_session", Context.MODE_PRIVATE)

    var currentUserId: String
        get() = sharedPreferences.getString(PREF_USER_ID, "") ?: ""
        set(value) = sharedPreferences.edit().putString(PREF_USER_ID, value).apply()

    var accessToken: String?
        get() = sharedPreferences.getString(PREF_ACCESS_TOKEN, null)
        set(value) = sharedPreferences.edit().putString(PREF_ACCESS_TOKEN, value).apply()


    var deviceId: String
        get() = sharedPreferences.getString(PREF_DEVICE_ID, null) ?: ""
        set(value) = sharedPreferences.edit().putString(PREF_DEVICE_ID, value).apply()

}
