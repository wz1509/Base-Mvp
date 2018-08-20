package com.wazing.mvp.presenter

import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.entity.HomeEntity
import com.wazing.mvp.model.MainModel
import com.wazing.mvp.model.callback.ResultCallBack

class MainPresenter : BasePresenter<MainContract.Model, MainContract.View>(), MainContract.Presenter {

    override fun createModel(): MainContract.Model = MainModel()

    override fun getHomeList(pageSize: Int) {
        model?.getHomeList(pageSize, object : ResultCallBack.SimpleResultCallBack<HomeEntity>() {
            override fun onSuccess(data: HomeEntity) {
                view?.onHomeList(data)
            }

            override fun onFail(errorMsg: String) {
                view?.onApiFail(errorMsg)
            }
        })
    }

}