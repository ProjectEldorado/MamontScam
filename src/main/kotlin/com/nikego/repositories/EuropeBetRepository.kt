package com.nikego.repositories

import com.nikego.clients.EuropeBetApi
import com.nikego.model.base.BetCompany
import com.nikego.model.base.uni.BetDiscipline
import com.nikego.utils.extensions.toUni
import javax.inject.Singleton

@Singleton
class EuropeBetRepository(private val europeBetApi: EuropeBetApi) {

    fun getBetsData(betDisciplines: List<BetDiscipline>) =
        europeBetApi.getLeagues()
            .filter {
                it.sportId in BetCompany.BETCITY.allowedDisciplineIds
                        && BetCompany.BETCITY.betDisciplineToId
                    .filterKeys { betDiscipline -> betDisciplines.contains(betDiscipline) }.containsValue(it.sportId)
            }
            .flatMap { europeBetApi.getBets(it.id) }
            .map { it.toUni() }
}