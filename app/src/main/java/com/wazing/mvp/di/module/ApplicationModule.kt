package com.wazing.mvp.di.module

import android.content.Context
import com.wazing.mvp.application.AppApplication
import com.wazing.mvp.model.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AppApplication) {

    @Provides
    @Singleton
    fun provideApplication(): AppApplication = application

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}