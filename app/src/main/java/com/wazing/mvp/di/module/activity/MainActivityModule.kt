package com.wazing.mvp.di.module.activity

import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.ui.activity.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideView(activity: MainActivity): MainContract.View = activity

}