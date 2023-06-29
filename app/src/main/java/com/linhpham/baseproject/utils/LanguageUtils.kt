package com.linhpham.baseproject.utils

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.linhpham.baseproject.data.utils.Language



/**
 * Created by Linh on 12/15/2022.
 **/
object LanguageUtils {
    fun getListLanguage(context: Context): List<Language> {
        return listOf(
            Language(null, "Vietnamese","Vietnamese", "vi"),
            Language(null, "Catalan", "Catalan","ca"),

        )
    }

    fun getLanguage(languageCode: String, context: Context) : Language {
        return getListLanguage(context).firstOrNull { it.code == languageCode} ?:  Language(null, "Vietnamese","Vietnamese", "vi")
    }

    /**
     * Call this on the main thread as it may require Activity.restart()
     * */
    fun changeLanguage(codeLanguage: String) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(codeLanguage)
        AppCompatDelegate.setApplicationLocales(appLocale)
    }

}
