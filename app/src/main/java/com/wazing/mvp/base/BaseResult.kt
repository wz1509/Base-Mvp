package com.wazing.mvp.base

class BaseResult<T>(val errorCode: Int,
                    val errorMsg: String,
                    val data: T)