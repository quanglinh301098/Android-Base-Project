package com.linhpham.goodnight.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import com.linhpham.goodnight.MyApplication
import com.linhpham.goodnight.data.utils.Session
import java.util.*


object CommonUtils {
    fun generateId(context: Context): String {
        val session = Session(context)
        return "${session.deviceId}-${UUID.randomUUID()}"
    }

    fun generateId(): String {
        val session = Session(MyApplication.INSTANCE)
        return "${session.deviceId}-${UUID.randomUUID()}"
    }

    fun isDarkMode(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            context.resources.configuration.isNightModeActive
        } else {
            context.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        }
    }

    fun getTimeStamp(date:Date? = Date()):Double = (date?.time?:0L)/1000.0
}
