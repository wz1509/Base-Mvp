package com.wazing.mvp.di.module

import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.contract.MainContract
import dagger.Module
import dagger.Provides

@Module
class ViewModule @JvmOverloads constructor(
        private val mainView: MainContract.View? = null,
        private val categoryView: CategoryContract.View? = null
) {

    @Provides
    fun provideMainView() = mainView!!

    @Provides
    fun provideCategoryView() = categoryView!!

}