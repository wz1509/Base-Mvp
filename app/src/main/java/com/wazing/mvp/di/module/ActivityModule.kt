package com.wazing.mvp.di.module

import com.wazing.mvp.di.scope.ActivityScope
import com.wazing.mvp.di.module.activity.MainActivityModule
import com.wazing.mvp.di.module.fragment.FrameActivityProvider
import com.wazing.mvp.ui.activity.FrameActivity
import com.wazing.mvp.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivitytInjector(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [FrameActivityProvider::class])
    abstract fun bindFrameActivitytInjector(): FrameActivity

}