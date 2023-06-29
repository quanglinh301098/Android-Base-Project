package com.linhpham.goodnight.data.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Session @Inject constructor(context: Context) {
    companion object {
        const val PREF_USER_ID = "user_id"
        const val PREF_DEVICE_ID = "device_id"
        const val PREF_SKIP_LOGIN = "skip_login"
        const val PREF_ACCESS_TOKEN = "access_token"
        const val PREF_REFRESH_TOKEN = "refresh_token"
        const val LAST_SYNC_DATE = "last_sync_date"
        const val LAST_SYNC_WALLET_DATE = "last_sync_wallet_date"
        const val CURRENT_SELECTED_USER_ID = "current_selected_user_id"

    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(context.packageName + "_session", Context.MODE_PRIVATE)

    var currentUserId: String
        get() = sharedPreferences.getString(PREF_USER_ID, "") ?: ""
        set(value) = sharedPreferences.edit().putString(PREF_USER_ID, value).apply()

    var accessToken: String?
        get() = sharedPreferences.getString(PREF_ACCESS_TOKEN, null)
        set(value) = sharedPreferences.edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var refreshToken: String?
        get() = sharedPreferences.getString(PREF_REFRESH_TOKEN, null)
        set(value) = sharedPreferences.edit().putString(PREF_REFRESH_TOKEN, value).apply()

    var deviceId: String
        get() = sharedPreferences.getString(PREF_DEVICE_ID, null) ?: ""
        set(value) = sharedPreferences.edit().putString(PREF_DEVICE_ID, value).apply()

    var isSkippedLogin: Boolean
        get() = sharedPreferences.getBoolean(PREF_SKIP_LOGIN, false)
        set(value) = sharedPreferences.edit().putBoolean(PREF_SKIP_LOGIN, value).apply()

    @Suppress("unused")
    var lastSyncDate: Long
        get() = sharedPreferences.getLong(LAST_SYNC_DATE, 0)
        set(value) = sharedPreferences.edit().putLong(LAST_SYNC_DATE, value).apply()

    var lastSyncWalletDate: Long
        get() = sharedPreferences.getLong(LAST_SYNC_WALLET_DATE, 0)
        set(value) = sharedPreferences.edit().putLong(LAST_SYNC_WALLET_DATE, value).apply()

    var currentSelectedUserId: String?
        get() = sharedPreferences.getString(CURRENT_SELECTED_USER_ID, null)
        set(value) = sharedPreferences.edit().putString(CURRENT_SELECTED_USER_ID, value).apply()

}
