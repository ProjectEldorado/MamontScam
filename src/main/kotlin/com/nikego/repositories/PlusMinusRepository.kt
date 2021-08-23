package com.nikego.repositories

import com.nikego.clients.PlusMinusApi
import com.nikego.model.base.BetCompany
import com.nikego.model.base.uni.BetDiscipline
import com.nikego.model.base.uni.Uni
import com.nikego.utils.Try
import com.nikego.utils.extensions.toObservable
import com.nikego.utils.extensions.toUni
import io.reactivex.Observable
import javax.inject.Singleton

@Singleton
class PlusMinusRepository(private val plusMinusApi: PlusMinusApi) {

    fun getBetsData(betDisciplines: List<BetDiscipline>): Observable<Try<Uni>> =
        BetCompany.PLUS_MINUS.betDisciplineToId
            .filterKeys { it in betDisciplines }
            .values
            .toObservable()
            .flatMapSingle { plusMinusApi.getCountriesForSport(it) }
            .map { it.dCountries }
            .flatMap { countries ->
                countries.toObservable().flatMapSingle { plusMinusApi.getTournamentsForCountry(it.iD, it.sportId) }
            }
            .map { it.dTournaments }
            .flatMap { tournaments ->
                tournaments.turnaments.toObservable()
                    .flatMapSingle {
                        plusMinusApi.getEventsForTournament(it.iD, tournaments.country.iD, tournaments.sport.iD)
                    }
            }
            .map { it.dEvents }
            .flatMap { Observable.fromIterable(it) }
            .map { it.toUni() }
}