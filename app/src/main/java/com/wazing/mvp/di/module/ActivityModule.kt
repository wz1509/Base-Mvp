package com.wazing.mvp.di.module

import android.app.Activity
import com.wazing.mvp.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity(): Activity = activity
}