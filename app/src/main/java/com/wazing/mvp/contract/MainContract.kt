package com.wazing.mvp.contract

import com.wazing.mvp.base.BaseContract
import com.wazing.mvp.model.callback.ResultCallBack

interface MainContract {

    interface View : BaseContract.View {

        fun onResult(result: String)
    }

    /**
     * 如果后面继承了BasePresenter，这里就不需要重复继承 BaseContract.Presenter
     */
    interface Presenter {

        fun getToday()
    }

    interface Model : BaseContract.Model {

        fun getToday(callback: ResultCallBack<String>)
    }

}