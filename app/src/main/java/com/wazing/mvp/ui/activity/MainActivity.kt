package com.wazing.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.wazing.mvp.R
import com.wazing.mvp.base.BaseMvpActivity
import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.di.module.ViewModule
import com.wazing.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity<MainPresenter>(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        request_network.setOnClickListener {
            presenter.getToday()
        }
        to_fragment.setOnClickListener {
            // this.finish()
            startActivity(Intent(this@MainActivity, FrameActivity::class.java))
        }
    }

    override fun injectPresenter() {
        getActivityComponent(ViewModule(this))
                .inject(this)
    }

    override fun onResult(result: String) {
        content_text.text = result
    }

    override fun onApiFail(msg: String) {
        content_text.text = msg
    }

}
