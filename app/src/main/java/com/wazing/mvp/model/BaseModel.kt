package com.wazing.mvp.model

import android.util.Log
import com.wazing.mvp.contract.BaseContract
import com.wazing.mvp.model.network.ApiManager
import com.wazing.mvp.model.network.ApiService
import io.reactivex.disposables.CompositeDisposable

abstract class BaseModel : BaseContract.Model {

    val disposables: CompositeDisposable by lazy(LazyThreadSafetyMode.NONE) {
        CompositeDisposable()
    }

    val apiService: ApiService by lazy(LazyThreadSafetyMode.NONE) {
        ApiManager.instance.create(ApiService::class.java)
    }

    override fun onDestroy() {
        Log.d("zz","BaseModel onDestroy()")
        disposables.clear()
    }
}