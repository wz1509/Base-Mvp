package com.wazing.mvp.di.component

import android.app.Activity
import com.wazing.mvp.di.ActivityScope
import com.wazing.mvp.di.module.ActivityModule
import com.wazing.mvp.di.module.ModelModule
import com.wazing.mvp.di.module.ViewModule
import com.wazing.mvp.ui.fragment.CategoryFragment
import com.wazing.mvp.ui.activity.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class],
        modules = [ActivityModule::class, ModelModule::class, ViewModule::class])
interface ActivityComponent {

    fun getActivity(): Activity

    fun inject(activity: MainActivity)

    fun inject(fragment: CategoryFragment)
}