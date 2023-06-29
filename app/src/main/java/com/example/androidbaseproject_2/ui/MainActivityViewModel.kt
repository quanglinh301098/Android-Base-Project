package com.example.androidbaseproject_2.ui

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidbaseproject_2.base.BaseActivityViewModel
import com.example.androidbaseproject_2.data.shared_preferences.SharedPreferencesHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val sharedPreferencesHelper: SharedPreferencesHelper) :
    BaseActivityViewModel() {

    private val _currentUserId = MutableLiveData<String>()
    val currentUserId = _currentUserId

    fun setCurrentUser(user: String) {
        sharedPreferencesHelper.setCurrentUserId(user)
        getCurrentUser()
    }

    fun getCurrentUser() {
        currentUserId.value = sharedPreferencesHelper.getCurrentUserId()
    }


}

