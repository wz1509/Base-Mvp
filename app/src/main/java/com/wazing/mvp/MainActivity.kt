package com.wazing.mvp

import android.os.Bundle
import com.wazing.mvp.base.BaseMvpActivity
import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.entity.HomeEntity
import com.wazing.mvp.presenter.MainPresenter
import com.wazing.mvp.utils.ExpandUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity<MainContract.View, MainPresenter>(), MainContract.View {

    private var pageSize = 0

    override fun createPresenter(): MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        request_network.setOnClickListener {
            presenter.getHomeList(pageSize)
            pageSize++
            // this.finish()
        }
        finish_activity.setOnClickListener {
            this.finish()
        }
    }

    override fun onHomeList(result: HomeEntity) {
        val sb = StringBuilder()
        for (item in result.datas) {
            sb.append(item.title).append("\n")
        }
        content_text.text = sb
    }

    override fun onApiFail(msg: String) {
        ExpandUtils.loge(msg = msg)
    }

}
