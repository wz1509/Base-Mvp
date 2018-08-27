package com.wazing.mvp.presenter

import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.model.CategoryModel
import com.wazing.mvp.model.callback.ResultCallBack
import com.wazing.mvp.ui.fragment.CategoryFragment
import javax.inject.Inject

class CategoryPresenter @Inject constructor(
        private val model: CategoryModel, private val view: CategoryFragment
) : CategoryContract.Presenter {

    override fun getGankList(category: String, countSize: Int, pageSize: Int) {
        model.getGankList(category, countSize, pageSize, object : ResultCallBack.SimpleResultCallBack<String>() {
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