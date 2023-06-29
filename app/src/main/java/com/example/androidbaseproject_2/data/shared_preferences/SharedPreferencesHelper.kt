package com.example.androidbaseproject_2.data.shared_preferences

import androidx.lifecycle.MutableLiveData

interface SharedPreferencesHelper {
    val currentUserId : MutableLiveData<String>
    fun setCurrentUserId(storeId: String)
    fun getCurrentUserId(): String

}