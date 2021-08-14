package com.nikego.utils

import com.nikego.exceptions.NullNotAllowedException

sealed class Try<T> {
    private data class Success<T>(val value: T) : Try<T>()
    private data class Failure<Nothing>(val e: Exception) : Try<Nothing>()

    fun <R> map(transform: (T) -> R?) =
        when (this) {
            is Success -> runSafely { transform(value) }
            is Failure -> Failure(e)
        }

    fun <R> fold(onSuccess: (T) -> R, onFailure: (Exception) -> R) =
        when (this) {
            is Success -> onSuccess(value)
            is Failure -> onFailure(e)
        }

    fun materialize(onFailure: (Exception) -> T) =
        when (this) {
            is Success -> value
            is Failure -> onFailure(e)
        }

    companion object {

        fun <T> runSafely(f: () -> T?) = try {
            f()?.let { Success(it) } ?: throw NullNotAllowedException()
        } catch (e: Exception) {
            Failure(e)
        }
    }
}