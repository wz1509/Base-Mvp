package com.wazing.mvp.di.module

import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.model.CategoryModel
import com.wazing.mvp.model.MainModel
import dagger.Module
import dagger.Provides

@Module
class ModelModule {

    @Provides
    fun provideMainModel(): MainContract.Model = MainModel()

    @Provides
    fun provideCategoryModel(): CategoryContract.Model = CategoryModel()
}