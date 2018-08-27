package com.wazing.mvp.presenter

import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.model.MainModel
import com.wazing.mvp.model.callback.ResultCallBack
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private val model: MainModel, private val view: MainContract.View
) : MainContract.Presenter {

    override fun getToday() {
        model.getToday(object : ResultCallBack.SimpleResultCallBack<String>() {
            override fun onSuccess(data: String) {
                view.onResult(data)
            }

            override fun onFail(errorMsg: String) {
                view.onApiFail(errorMsg)
            }
        })
    }

    override fun detachView() {
        model.onDestroy()
    }

}