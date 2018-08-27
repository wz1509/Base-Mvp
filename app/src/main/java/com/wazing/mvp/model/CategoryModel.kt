package com.wazing.mvp.model

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.model.callback.ResultCallBack
import com.wazing.mvp.model.network.ApiCodeException
import com.wazing.mvp.model.network.ApiService
import com.wazing.mvp.model.network.RxHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoryModel @Inject constructor(private val apiService: ApiService) : CategoryContract.Model {

    private val disposables by lazy { CompositeDisposable() }

    override fun getGankList(category: String, countSize: Int, pageSize: Int, callback: ResultCallBack<String>) {
        apiService.getGankList(category, countSize, pageSize)
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