package com.wazing.mvp.base

import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.wazing.mvp.application.AppApplication
import com.wazing.mvp.di.component.ActivityComponent
import com.wazing.mvp.di.component.DaggerActivityComponent
import com.wazing.mvp.di.module.ActivityModule
import com.wazing.mvp.di.module.ModelModule
import com.wazing.mvp.di.module.ViewModule
import javax.inject.Inject

abstract class BaseMvpActivity<P : BaseContract.Presenter> : BaseActivity(), BaseContract.View {

    @Inject lateinit var presenter: P

    private val dialog by lazy { AlertDialog.Builder(this).create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectPresenter()
        lifecycle.addObserver(presenter)
    }

    fun getActivityComponent(view: ViewModule): ActivityComponent {
        return DaggerActivityComponent.builder()
                .applicationComponent(AppApplication.get(this).applicationComponent)
                .activityModule(ActivityModule(this))
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

    abstract fun injectPresenter()

}