package com.wazing.mvp.di.module

import android.app.Activity
import android.support.v4.app.Fragment
import com.wazing.mvp.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun provideActivity(): Activity = fragment.activity!!

}