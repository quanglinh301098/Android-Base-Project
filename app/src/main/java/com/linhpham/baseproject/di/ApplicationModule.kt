package com.linhpham.baseproject.di

import android.content.Context
import androidx.room.Room
import com.linhpham.baseproject.BuildConfig
import com.linhpham.baseproject.data.AppDataDatabase
import com.linhpham.baseproject.data.utils.ApiClient
import com.linhpham.baseproject.data.utils.AuthorizationInterceptor
import com.linhpham.baseproject.data.utils.Session
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideSession(@ApplicationContext context: Context): Session = Session(context)

    @Provides
    @Singleton
    fun provideAuthorizationInterceptor(session: Session) = AuthorizationInterceptor(session)

    @Provides
    @Singleton
    fun provideApiClient(authorizationInterceptor: AuthorizationInterceptor): ApiClient {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply {
                setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
            }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(
                OkHttpClient.Builder()
                    // A zero value means no timeout at all.
                    // This is enforced because our client isn't able to send/receive a request body/response body always to/from the server within the defined timeout.
                    // This guarantees that whatever the size of the image being uploaded is, it won't get `SocketTimeoutException` unless the server itself has issues.
                    .writeTimeout(0, TimeUnit.SECONDS)
                    .readTimeout(0, TimeUnit.SECONDS)
                    .addInterceptor(authorizationInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDataDatabase::class.java, "Base Project Data Base"
    ).fallbackToDestructiveMigration()
        .build()

}
