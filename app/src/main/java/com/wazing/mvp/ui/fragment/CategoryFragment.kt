package com.wazing.mvp.ui.fragment

import android.os.Bundle
import android.view.View
import com.wazing.mvp.R
import com.wazing.mvp.base.BaseMvpFragment
import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.di.module.ViewModule
import com.wazing.mvp.presenter.CategoryPresenter
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseMvpFragment<CategoryPresenter>(), CategoryContract.View {

    override fun getContentViewResId(): Int = R.layout.fragment_category

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getGankList("Android", 5, 1)
    }

    override fun injectPresenter() {
        getFragmentComponent(ViewModule(this))
                .inject(this)
    }

    override fun onResult(result: String) {
        content_text.text = result
    }

    override fun onApiFail(msg: String) {
        content_text.text = msg
    }
}