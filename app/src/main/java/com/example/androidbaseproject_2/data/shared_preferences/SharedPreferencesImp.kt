package com.example.androidbaseproject_2.data.shared_preferences

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesImp @Inject constructor(val sharedPreferences: SharedPreferences) : SharedPreferencesHelper {
    override val currentUserId: MutableLiveData<String> = MutableLiveData()
    override fun getCurrentUserId(): String =
        sharedPreferences.getString(PREF_USER_ID, "") ?: ""

    override fun setCurrentUserId(userId: String) {
        sharedPreferences.edit().apply {
            putString(PREF_USER_ID, userId)
        }.apply()
        this.currentUserId.postValue(userId)
    }

    companion object {
        const val PREF_USER_ID = "store_id"
    }
}