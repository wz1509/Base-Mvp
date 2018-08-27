package com.wazing.mvp.application

import android.app.Activity
import android.app.Application
import android.content.Context
import com.wazing.mvp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class AppApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

//    val mAppComponent: AppComponent by lazy {
//        DaggerApp.builder()
//                .applicationModule(AppModule(this))
//                .netModule(NetModule())
//                .build()
//    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create().inject(this)

        appApplication = this
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    companion object Factory {

        lateinit var appApplication: AppApplication
            private set

        fun get(context: Context): AppApplication = context.applicationContext as AppApplication
    }

}