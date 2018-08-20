package com.wazing.mvp.base

import com.wazing.mvp.application.AppApplication
import com.wazing.mvp.model.network.ApiService
import io.reactivex.disposables.CompositeDisposable

abstract class BaseModel : BaseContract.Model {

    val disposables: CompositeDisposable by lazy(LazyThreadSafetyMode.NONE) {
        CompositeDisposable()
    }

    val apiService: ApiService by lazy(LazyThreadSafetyMode.NONE) {
        AppApplication.appApplication.applicationComponent.getApiService()
    }

    override fun onDestroy() = disposables.clear()
}