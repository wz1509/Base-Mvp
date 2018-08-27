package com.wazing.mvp.model.network

import android.accounts.NetworkErrorException
import android.util.Log
import com.google.gson.JsonSyntaxException
import com.google.gson.stream.MalformedJsonException
import java.net.ConnectException
import java.net.SocketTimeoutException

class ApiCodeException(errorMsg: String) : Exception(errorMsg) {

    companion object {
        fun checkException(ex: Throwable): String {
            Log.e("zz","${ex.message}",ex)
            return when (ex) {
                is SocketTimeoutException -> "连接超时，请检查网络"
                is NetworkErrorException -> "网络连接错误，请检查网络"
                is ConnectException -> "无网络连接，请检查网络"
                is MalformedJsonException, is JsonSyntaxException -> "解析Json异常"
                is ApiCodeException -> ex.message ?: "empty message"
                else -> "未知错误"
            }
        }
    }
}