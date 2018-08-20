package com.wazing.mvp.model.network

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/today")
    fun getToday(): Observable<ResponseBody>

    @GET("api/data/{category}/{count}/{page}")
    fun getGankList(@Path("category") category: String,
                    @Path("count") count: Int,
                    @Path("page") page: Int): Observable<ResponseBody>

}