package com.wazing.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.wazing.mvp.R
import com.wazing.mvp.R.id.*
import com.wazing.mvp.base.BaseActivity
import com.wazing.mvp.contract.MainContract
import com.wazing.mvp.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var contentText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(presenter)

        contentText = findViewById(R.id.content_text)

        findViewById<View>(R.id.request_network).setOnClickListener {
            presenter.getToday()
        }

        findViewById<View>(R.id.to_fragment).setOnClickListener {
            // this.finish()
            startActivity(Intent(this@MainActivity, FrameActivity::class.java))
        }
    }

    override fun onResult(result: String) {
        contentText.text = result
    }

    override fun onApiFail(msg: String) {
        contentText.text = msg
    }

}
