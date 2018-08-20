package com.wazing.mvp.application

import android.app.Application
import android.content.Context
import com.wazing.mvp.di.component.ApplicationComponent
import com.wazing.mvp.di.component.DaggerApplicationComponent
import com.wazing.mvp.di.module.ApplicationModule
import com.wazing.mvp.di.module.NetModule

class AppApplication : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .netModule(NetModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appApplication = this
    }

    companion object Factory {

        lateinit var appApplication: AppApplication
            private set

        fun get(context: Context): AppApplication = context.applicationContext as AppApplication
    }

}