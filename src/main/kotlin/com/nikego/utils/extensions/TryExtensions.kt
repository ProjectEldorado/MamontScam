package com.nikego.utils.extensions

import com.nikego.utils.Try

fun <T> Iterable<Try<T>>.getSuccess() = mapNotNull { it.fold({ it }, { null }) }
