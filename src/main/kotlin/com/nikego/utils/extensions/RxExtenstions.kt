package com.nikego.utils.extensions

import io.reactivex.Observable

fun <T> Iterable<T>.toObservable() = Observable.fromIterable(this)

fun <T> Observable<Iterable<T>>.flatten() = flatMap { Observable.fromIterable(it) }