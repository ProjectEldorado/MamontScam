package com.nikego.api

import com.nikego.clients.PlusMinusApi
import com.nikego.model.base.BetCompany
import com.nikego.utils.extensions.toObservable
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class PlusMinusApiTest(private val plusMinusApi: PlusMinusApi) {

    @Test
    fun `test get events`() {
        BetCompany.PLUS_MINUS.allowedDisciplineIds.toObservable()
            .flatMapSingle { plusMinusApi.getCountriesForSport(it) }
            .map { it.dCountries }
            .flatMap { countries ->
                countries.toObservable()
                    .flatMapSingle { plusMinusApi.getTournamentsForCountry(it.iD, it.sportId) }
            }.map { it.dTournaments }
            .flatMap { tournaments ->
                tournaments.turnaments.toObservable()
                    .flatMapSingle {
                        plusMinusApi.getEventsForTournament(it.iD, tournaments.country.iD, tournaments.sport.iD)
                    }
            }
            .doOnError { println(it.stackTraceToString()) }
            .toList()
            .blockingGet()
            .let {
                println(it)
                println(it.size)
            }
    }
}