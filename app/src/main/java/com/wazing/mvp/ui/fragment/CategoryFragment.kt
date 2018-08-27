package com.wazing.mvp.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.wazing.mvp.R
import com.wazing.mvp.R.id.content_text
import com.wazing.mvp.base.BaseFragment
import com.wazing.mvp.contract.CategoryContract
import com.wazing.mvp.presenter.CategoryPresenter
import javax.inject.Inject

class CategoryFragment : BaseFragment(), CategoryContract.View {

    @Inject
    lateinit var presenter: CategoryPresenter

    private lateinit var contentText: TextView

    override fun getContentViewResId(): Int = R.layout.fragment_category

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 注册
        lifecycle.addObserver(presenter)

        contentText = view.findViewById(R.id.content_text)

        presenter.getGankList("Android", 5, 1)
    }

    override fun onResult(result: String) {
        contentText.text = result
    }

    override fun onApiFail(msg: String) {
        contentText.text = msg
    }
}