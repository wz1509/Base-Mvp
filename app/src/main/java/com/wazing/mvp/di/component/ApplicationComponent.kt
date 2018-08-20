package com.wazing.mvp.di.component

import android.content.Context
import com.wazing.mvp.application.AppApplication
import com.wazing.mvp.di.module.ApplicationModule
import com.wazing.mvp.di.module.NetModule
import com.wazing.mvp.model.network.ApiService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetModule::class])
interface ApplicationComponent {

    fun getContext(): Context

    fun getApplication(): AppApplication

    fun getApiService(): ApiService

}