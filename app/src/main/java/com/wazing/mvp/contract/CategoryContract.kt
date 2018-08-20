package com.wazing.mvp.contract

import com.wazing.mvp.base.BaseContract
import com.wazing.mvp.model.callback.ResultCallBack

interface CategoryContract {

    interface View : BaseContract.View {
        fun onResult(result: String)
    }

    interface Presenter {
        fun getGankList(category: String, countSize: Int, pageSize: Int)
    }

    interface Model : BaseContract.Model {
        fun getGankList(category: String,
                        countSize: Int,
                        pageSize: Int,
                        callback: ResultCallBack<String>)
    }

}