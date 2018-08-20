package com.wazing.mvp.model

import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.entity.HomeEntity
import com.wazing.mvp.model.callback.ResultCallBack
import com.wazing.mvp.model.network.ApiCodeException
import com.wazing.mvp.model.network.RxHelper

class MainModel : BaseModel(), MainContract.Model {

    override fun getHomeList(pageSize: Int, callback: ResultCallBack<HomeEntity>) {
        apiService.getHomeList(pageSize)
                .doOnSubscribe { disposables.add(it) }
                .compose(RxHelper.handlerResult())
                .compose(RxHelper.ioMain())
                .subscribe({
                    callback.onSuccess(it)
                }, {
                    callback.onFail(ApiCodeException.checkException(it))
                })
    }

}