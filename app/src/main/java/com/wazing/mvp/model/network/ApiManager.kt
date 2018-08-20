package com.wazing.mvp.model.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiManager {

    private val mOkHttpClient: OkHttpClient
    private val mRetrofit: Retrofit

    init {
        val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.d("network logger", it)
        })
        mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logger)
                .build()

        mRetrofit = Retrofit.Builder()
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }

    companion object {

        private const val DEFAULT_TIMEOUT: Long = 15
        private const val BASE_URL = "http://www.wanandroid.com/"

        @Volatile
        private var sApiCreate: ApiManager? = null

        private fun initApiCreate(): ApiManager {
            if (sApiCreate == null) {
                synchronized(ApiManager::class.java) {
                    if (sApiCreate == null) {
                        sApiCreate = ApiManager()
                    }
                }
            }
            return sApiCreate!!
        }

        val instance: Retrofit get() = initApiCreate().mRetrofit
    }

}