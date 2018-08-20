package com.wazing.mvp.di.component

import android.app.Activity
import com.wazing.mvp.di.FragmentScope
import com.wazing.mvp.di.module.FragmentModule
import com.wazing.mvp.di.module.ModelModule
import com.wazing.mvp.di.module.ViewModule
import com.wazing.mvp.ui.fragment.CategoryFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class],
        modules = [FragmentModule::class, ModelModule::class, ViewModule::class])
interface FragmentComponent {

    fun getActivity(): Activity

    fun inject(fragment: CategoryFragment)
}