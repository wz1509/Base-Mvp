package com.wazing.mvp.di.module.fragment

import com.wazing.mvp.di.scope.FragmentScope
import com.wazing.mvp.ui.fragment.CategoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FrameActivityProvider {

    @FragmentScope
    @ContributesAndroidInjector(modules = [CategoryFragmentModule::class])
    abstract fun bindCategoryFragmentInjector(): CategoryFragment

}