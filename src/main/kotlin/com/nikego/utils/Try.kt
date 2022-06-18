package com.nikego.utils

import com.nikego.exceptions.NullNotAllowedException

sealed class Try<out T> {
    data class Success<T>(val value: T) : Try<T>()
    data class Failure(val e: Exception) : Try<Nothing>()

    inline fun <R> map(crossinline transform: (T) -> R?): Try<R> =
        flatMap { runSafely { transform(it) } }

    inline fun <R> flatMap(crossinline transform: (T) -> Try<R>): Try<R> =
        fold({ transform(it) }, { this as Failure })

    inline fun <R> fold(onSuccess: (T) -> R, onFailure: (Exception) -> R): R =
        when (this) {
            is Success -> onSuccess(value)
            is Failure -> onFailure(e)
        }

    fun getOrNull(): T? =
        fold({ it }, { null })

    companion object {

        inline fun <T> runSafely(f: () -> T?): Try<T> = try {
            f()?.let { Success(it) } ?: throw NullNotAllowedException()
        } catch (e: Exception) {
            Failure(e)
        }
    }
}
