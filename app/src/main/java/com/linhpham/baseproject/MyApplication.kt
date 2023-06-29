package com.linhpham.baseproject

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.provider.Settings
import androidx.multidex.MultiDexApplication
import com.linhpham.baseproject.data.utils.Session
import com.linhpham.baseproject.utils.LocaleManager
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.charset.Charset
import java.util.*

@HiltAndroidApp
class MyApplication : MultiDexApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.updateContext(base))
    }

    override fun onConfigurationChanged(newConfig: android.content.res.Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.updateContext(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        if (Session(this).deviceId.isEmpty()) {
            getDeviceId()
        }
    }

    @SuppressLint("HardwareIds")
    private fun getDeviceId() {
        CoroutineScope(Dispatchers.IO).launch {
            val session = Session(this@MyApplication)
            val androidId = Settings.Secure.getString(
                contentResolver,
                Settings.Secure.ANDROID_ID
            )?.takeIf { it.isNotEmpty() } ?: BuildConfig.APPLICATION_ID
            session.deviceId =
                UUID.nameUUIDFromBytes(androidId.toByteArray(Charset.forName("UTF-8")))
                    .toString()
        }
    }

    companion object {
        lateinit var INSTANCE: Application
    }

}
