package com.wazing.mvp.presenter

import android.util.Log
import com.wazing.mvp.contract.BaseContract

abstract class BasePresenter<M : BaseContract.Model, V : BaseContract.View> : BaseContract.Presenter<V> {

    var model: M? = null
    var view: V? = null

    init {
        Log.d("zz", "BasePresenter init")
        this.model = this.createModel()
    }

    override fun attachView(view: V) {
        Log.d("zz", "绑定View")
        this.view = view
    }

    override fun detachView() {
        Log.d("zz", "销毁View view = $view  mode = $model  START")
        model?.onDestroy()
        view = null
        Log.d("zz", "销毁View  END")
    }

    abstract fun createModel(): M

}