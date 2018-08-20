package com.wazing.mvp.model.network

import android.text.TextUtils
import com.wazing.mvp.base.BaseResult
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Observer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxHelper {

    fun <T> applySingleIoSchedulers(): SingleTransformer<T, T> {
        return SingleTransformer {
            it.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> ioMain(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> handlerResult(): ObservableTransformer<BaseResult<T>, T> {
        return ObservableTransformer { upstream ->
            upstream.flatMap { t ->
                if (t.errorCode == 0) {
                    val observable: Observable<T> = object : Observable<T>() {
                        override fun subscribeActual(observer: Observer<in T>) {
                            try {
                                observer.onNext(t.data)
                                observer.onComplete()
                            } catch (e: Exception) {
                                observer.onError(e)
                            }
                        }
                    }
                    observable
                } else {
                    Observable.error {
                        val msg = if (TextUtils.isEmpty(t.errorMsg)) "empty error message" else t.errorMsg
                        return@error ApiCodeException(msg)
                    }
                }
            }
        }
    }

}