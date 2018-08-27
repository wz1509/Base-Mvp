package com.wazing.mvp.model.callback

interface ResultCallBack<T> {

    fun onSuccess(data: T)

    fun onSuccess(list: List<T>)

    fun onFail(errorMsg: String)

    open class SimpleResultCallBack<T> :ResultCallBack<T>{
        override fun onSuccess(data: T) {
        }

        override fun onSuccess(list: List<T>) {
        }

        override fun onFail(errorMsg: String) {
        }
    }

}