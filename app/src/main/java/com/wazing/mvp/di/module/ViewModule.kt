package com.wazing.mvp.di.module

import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.contract.MainContract
import dagger.Module
import dagger.Provides

@Module
class ViewModule {

    private var mainView: MainContract.View? = null

    private var categoryView: CategoryContract.View? = null

    constructor(mainView: MainContract.View) {
        this.mainView = mainView
    }

    constructor(categoryView: CategoryContract.View) {
        this.categoryView = categoryView
    }

    @Provides
    fun provideMainView() = mainView!!

    @Provides
    fun provideCategoryView() = categoryView!!

}