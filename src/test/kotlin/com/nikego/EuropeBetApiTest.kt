package com.nikego

import com.nikego.clients.EuropeBetApi
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class EuropeBetApiTest(private val europeBetApi: EuropeBetApi) {

    @Test
    fun testGetLeagues() {
        europeBetApi.getLeagues()
            .toList()
            .blockingGet()
            .also {
                println(it)
                println(it.filter { it.matchCount > 0 }.size)
            }
    }

    @Test
    fun testGetBetsByLeague() {
        europeBetApi.getLeagues()
            .filter { it.sportId == 1 && it.matchCount > 0 }
            .map { it.id }
            .flatMap { europeBetApi.getBets(it) }
            .toList()
            .blockingGet()
            .also {
                println(it)
                println(it.size)
            }
    }
}