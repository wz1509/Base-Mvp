package com.wazing.mvp.di.component

import com.wazing.mvp.application.AppApplication
import com.wazing.mvp.di.module.ActivityModule
import com.wazing.mvp.di.module.NetModule
import com.wazing.mvp.model.network.ApiService
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import retrofit2.Retrofit

@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    NetModule::class
])
interface AppComponent {

    fun inject(application: AppApplication)

    fun getRetrofit(): Retrofit


    fun getApiService(): ApiService
}