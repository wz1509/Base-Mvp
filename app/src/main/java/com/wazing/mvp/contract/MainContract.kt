package com.wazing.mvp.contract

import com.wazing.mvp.entity.HomeEntity
import com.wazing.mvp.model.callback.ResultCallBack

interface MainContract {

    interface View : BaseContract.View {

        fun onHomeList(result: HomeEntity)
    }

    /**
     * 如果后面继承了BasePresenter，这里就不需要重复继承 BaseContract.Presenter
     */
    interface Presenter {

        fun getHomeList(pageSize: Int)
    }

    interface Model : BaseContract.Model {

        fun getHomeList(pageSize: Int = 0, callback: ResultCallBack<HomeEntity>)
    }

}