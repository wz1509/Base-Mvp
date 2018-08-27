package com.wazing.mvp.ui.activity

import android.os.Bundle
import android.widget.FrameLayout
import com.wazing.mvp.base.BaseActivity
import com.wazing.mvp.ui.fragment.CategoryFragment

class FrameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val frameLayout = FrameLayout(this)
        frameLayout.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT)
        setContentView(frameLayout)

        supportFragmentManager.beginTransaction()
                .add(android.R.id.content, CategoryFragment())
                .commitAllowingStateLoss()
    }

}