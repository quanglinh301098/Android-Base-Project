package com.example.androidbaseproject_2.injection

import android.content.Context
import android.content.SharedPreferences
import com.example.androidbaseproject_2.data.shared_preferences.SharedPreferencesHelper
import com.example.androidbaseproject_2.data.shared_preferences.SharedPreferencesImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(sharedPreferences: SharedPreferences): SharedPreferencesHelper =
        SharedPreferencesImp(sharedPreferences)

}