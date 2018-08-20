package com.wazing.mvp.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent


/**
 * 封装通用View和Presenter
 */
interface BaseContract {

    /**
     * View通用方法
     */
    interface View {

        fun showLoading()

        fun hideLoading()

        fun onApiFail(msg: String)
    }

    /**
     * Presenter通用方法
     */
    interface Presenter: LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun detachView()
    }

    interface Model {

        fun onDestroy()
    }

}