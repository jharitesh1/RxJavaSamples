package com.example.rxjavasamples

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class IntervalOperator {

}

fun main() {
    interval()
}

public fun interval() {
    Observable.interval(0, 2, TimeUnit.SECONDS)
//        .take(5)
        .flatMap {
            return@flatMap Observable.create<String> { emitter ->
                Log.d("IntervalOperator", "Create")
                emitter.onNext("IntervalOperator example")
                emitter.onComplete()
            }
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            Log.d("IntervalOperator", it)
        }
}
