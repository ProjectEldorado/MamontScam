package com.nikego.api

import com.nikego.clients.EuropeBetApi
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.Test

@MicronautTest
class EuropeBetApiTest(private val europeBetApi: EuropeBetApi) {

    @Test
    fun `test get leagues`() {
        europeBetApi.getLeagues()
            .toList()
            .blockingGet()
            .also {
                println(it)
                println(it.filter { it.matchCount > 0 }.size)
            }
    }

    @Test
    fun `test get bets`() {
        europeBetApi.getLeagues()
            .filter { it.sportId == 1 && it.matchCount > 0 }
            .map { it.id }
            .flatMap { europeBetApi.getBets(it) }
            .subscribeOn(Schedulers.io())
            .toList()
            .blockingGet()
            .also {
                println(it)
                println(it.size)
            }
    }
}