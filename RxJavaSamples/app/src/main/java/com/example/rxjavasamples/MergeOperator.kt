package com.example.rxjavasamples

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MergeOperator {

}

fun main() {
    merge()
}

/*
     * Using merge operator to combine Observable : merge does not maintain
     * the order of Observable.
     * It will emit all the 7 values may not be in order
     * Ex - "A1", "B1", "A2", "A3", "A4", "B2", "B3" - may be anything
     */
public fun merge() {
    val observableA = Observable.fromArray("A1", "A2", "A3", "A4")
    val observableB = Observable.fromArray("B1", "B2", "B3", "B4")

    Observable.merge(observableA, observableB)
        .subscribe(getObserver())
}

public fun getObserver(): Observer<String> {
    return object : Observer<String> {

        override fun onSubscribe(d: Disposable) {
            println(" onSubscribe : " + d.isDisposed)
        }

        override fun onNext(value: String) {
            println(" onNext : value : $value")
        }

        override fun onError(e: Throwable) {
            println(" onError : " + e.message)
        }

        override fun onComplete() {
            println(" onComplete")
        }
    }
}
