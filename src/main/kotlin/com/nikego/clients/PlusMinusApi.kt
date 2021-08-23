package com.nikego.clients

import com.nikego.configuration.plusminus.PlusMinusConfiguration
import com.nikego.model.plusminus.countries.PlusMinusCountries
import com.nikego.model.plusminus.events.PlusMinusEvents
import com.nikego.model.plusminus.tournaments.PlusMinusTournaments
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Retryable
import io.reactivex.Single

@Client(PlusMinusConfiguration.PLUS_MINUS_API_URL)
@Retryable(attempts = "10", delay = "0.001s")
interface PlusMinusApi {

    @Post("/GetCountriesForSportByPeriod")
    fun getCountriesForSport(sportId: Int, period: Int = 0, culture: String = "ru-ru"): Single<PlusMinusCountries>

    @Post("/GetTournamentsWithEventsCountByPeriod")
    fun getTournamentsForCountry(
        countryId: Int,
        sportId: Int,
        period: Int = 0,
        culture: String = "ru-ru"
    ): Single<PlusMinusTournaments>

    @Post("/GetTournamamentEventsByPeriod")
    fun getEventsForTournament(
        tournamentId: Int,
        countryId: Int,
        sportId: Int,
        period: Int = 0,
        culture: String = "ru-ru",
        viewBetTypeList: List<String> = listOf("20")
    ): Single<PlusMinusEvents>
}