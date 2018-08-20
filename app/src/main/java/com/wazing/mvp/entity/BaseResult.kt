package com.wazing.mvp.entity

class BaseResult<T>(val errorCode: Int,
                    val errorMsg: String,
                    val data: T)