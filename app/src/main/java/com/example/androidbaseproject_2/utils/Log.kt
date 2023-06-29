package com.example.androidbaseproject_2.utils

import android.os.Build
import android.util.Log
import com.example.androidbaseproject_2.BuildConfig

object LogUtils {
    fun d(message: String){
        if (BuildConfig.DEBUG){
            Log.d("LogApplication",message)
        }
    }
}