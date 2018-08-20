package com.wazing.mvp.presenter

import com.wazing.mvp.base.BasePresenter
import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.model.callback.ResultCallBack
import javax.inject.Inject

class MainPresenter @Inject constructor(
        private var model: MainContract.Model, private var view: MainContract.View
) : BasePresenter(view, model), MainContract.Presenter {

    override fun getToday() {
        view.showLoading()
        model.getToday(object : ResultCallBack.SimpleResultCallBack<String>() {
            override fun onSuccess(data: String) {
                view.onResult(data)
                view.hideLoading()
            }

            override fun onFail(errorMsg: String) {
                view.onApiFail(errorMsg)
                view.hideLoading()
            }
        })
    }

}