package com.wazing.mvp.base

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import com.wazing.mvp.application.AppApplication
import com.wazing.mvp.di.component.DaggerFragmentComponent
import com.wazing.mvp.di.component.FragmentComponent
import com.wazing.mvp.di.module.FragmentModule
import com.wazing.mvp.di.module.ModelModule
import com.wazing.mvp.di.module.ViewModule
import javax.inject.Inject

abstract class BaseMvpFragment<P : BaseContract.Presenter> : BaseFragment(), BaseContract.View {

    @Inject
    lateinit var presenter: P

    private val dialog by lazy { AlertDialog.Builder(activity!!).create() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectPresenter()
        lifecycle.addObserver(presenter)
    }

    fun getFragmentComponent(view: ViewModule): FragmentComponent {
        return DaggerFragmentComponent.builder()
                .applicationComponent(AppApplication.get(activity!!).applicationComponent)
                .fragmentModule(FragmentModule(this))
                .modelModule(ModelModule())
                .viewModule(view)
                .build()
    }

    override fun showLoading() {
        dialog.setTitle("title")
        dialog.setMessage("加载中...")
        dialog.show()
    }

    override fun hideLoading() {
        dialog.dismiss()
    }

    override fun onApiFail(msg: String) {
    }

    abstract fun injectPresenter()
}