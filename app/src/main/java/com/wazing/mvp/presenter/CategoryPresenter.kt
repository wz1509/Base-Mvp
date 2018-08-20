package com.wazing.mvp.presenter

import com.wazing.mvp.base.BasePresenter
import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.model.callback.ResultCallBack
import javax.inject.Inject

class CategoryPresenter @Inject constructor(
        private var model: CategoryContract.Model, private var view: CategoryContract.View
) : BasePresenter(view, model), CategoryContract.Presenter {

    override fun getGankList(category: String, countSize: Int, pageSize: Int) {
        model.getGankList(category, countSize, pageSize, object : ResultCallBack.SimpleResultCallBack<String>() {
            override fun onSuccess(data: String) {
                view.onResult(data)
                view.hideLoading()
            }

            override fun onFail(errorMsg: String) {
                view.onApiFail(errorMsg)
            }
        })
    }
}