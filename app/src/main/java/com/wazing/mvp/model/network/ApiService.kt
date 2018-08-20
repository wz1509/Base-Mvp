package com.wazing.mvp.model.network

import com.wazing.mvp.entity.BaseResult
import com.wazing.mvp.entity.HomeEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("article/list/{pageSize}/json")
    fun getHomeList(@Path("pageSize") pageSize: Int) :Observable<BaseResult<HomeEntity>>

}