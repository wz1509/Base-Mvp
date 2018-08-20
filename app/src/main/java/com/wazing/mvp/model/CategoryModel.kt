package com.wazing.mvp.model

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.wazing.mvp.base.BaseModel
import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.model.callback.ResultCallBack
import com.wazing.mvp.model.network.ApiCodeException
import com.wazing.mvp.model.network.RxHelper

class CategoryModel : BaseModel(), CategoryContract.Model {

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
}