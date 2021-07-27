package com.nikego.service

import com.nikego.configuration.LeonConfiguration
import com.nikego.model.leon.bets.LeonBet
import com.nikego.model.leon.league.LeonSports
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Observable

@Client(LeonConfiguration.LEON_API_URL)
interface LeonApiClient {

    @Get("/betline/sports?ctag=ru-RU&flags=urlv2")
    fun getLeagues(): Observable<LeonSports>

    @Get("/betline/events/all?ctag=ru-RU&league_id={leagueId}")
    fun getEvents(leagueId: Long): Observable<LeonBet>
}