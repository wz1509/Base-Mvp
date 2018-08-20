package com.wazing.mvp.base

import android.os.Bundle
import com.wazing.mvp.contract.BaseContract

abstract class BaseMvpActivity<in V : BaseContract.View, out P : BaseContract.Presenter<V>>
    : BaseActivity(), BaseContract.View {

    open val presenter: P = this.createPresenter()

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(presenter)
        presenter.attachView(this as V)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    abstract fun createPresenter(): P

}