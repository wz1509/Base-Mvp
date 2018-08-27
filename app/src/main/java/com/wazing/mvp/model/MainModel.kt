package com.wazing.mvp.model

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.model.callback.ResultCallBack
import com.wazing.mvp.model.network.ApiCodeException
import com.wazing.mvp.model.network.ApiService
import com.wazing.mvp.model.network.RxHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainModel @Inject constructor(private val apiService: ApiService) : MainContract.Model {

    private val disposables by lazy { CompositeDisposable() }

    override fun getToday(callback: ResultCallBack<String>) {
        apiService.getToday()
                .doOnSubscribe { disposables.add(it) }
                .compose(RxHelper.ioMain())
                .subscribe({
                    val jsonElement = JsonParser().parse(it.string())
                    val result = GsonBuilder().setPrettyPrinting().create().toJson(jsonElement)
                    callback.onSuccess(result)
                }, {
                    callback.onFail(ApiCodeException.checkException(it))
                })
    }

    override fun onDestroy() {
        disposables.clear()
    }

}