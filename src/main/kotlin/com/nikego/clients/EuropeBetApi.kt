package com.nikego.clients

import com.nikego.configuration.europebet.EuropeBetConfiguration
import com.nikego.model.europebet.bets.EuropeBetBet
import com.nikego.model.europebet.leagues.EuropeBetLeague
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.Retryable
import io.reactivex.Observable

@Client(EuropeBetConfiguration.EUROPEBET_API_URL)
@Retryable(attempts = "10", delay = "0.001s")
interface EuropeBetApi {

    @Get("/leagues/?ln=en")
    fun getLeagues(): Observable<EuropeBetLeague>

    @Get("/matches/?marketGroup=basic&leagueId={leagueId}&ln=en")
    fun getBets(leagueId: Int): Observable<EuropeBetBet>
}