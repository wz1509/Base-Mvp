package com.wazing.mvp.base

import android.util.Log

abstract class BasePresenter(private var view: BaseContract.View?,
                             private val model: BaseContract.Model) : BaseContract.Presenter {

    override fun detachView() {
        Log.d("zz", "销毁View view = $view  START")
        model.onDestroy()
        view = null
        Log.d("zz", "销毁View  END")
    }

}