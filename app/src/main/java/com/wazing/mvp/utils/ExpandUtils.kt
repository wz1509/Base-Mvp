package com.wazing.mvp.utils

import android.util.Log

object ExpandUtils {

    private const val TAG = "zz"

    @JvmOverloads
    fun logd(tag: String = TAG, msg: String) {
        Log.d(tag, msg)
    }

    @JvmOverloads
    fun loge(tag: String = TAG, msg: String) {
        Log.e(tag, msg)
    }

}