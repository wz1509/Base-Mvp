package com.wazing.mvp.contract

import com.wazing.mvp.base.BaseContract
import com.wazing.mvp.model.callback.ResultCallBack

interface MainContract {

    interface View : BaseContract.View {

        fun onResult(result: String)
    }

    interface Presenter : BaseContract.Presenter {

        fun getToday()
    }

    interface Model : BaseContract.Model {

        fun getToday(callback: ResultCallBack<String>)
    }

}