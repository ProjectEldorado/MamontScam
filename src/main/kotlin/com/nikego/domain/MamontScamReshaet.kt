package com.nikego.domain

import com.nikego.model.base.BetCompany
import com.nikego.model.base.uni.BetsData
import com.nikego.model.domain.BetRequest
import com.nikego.repositories.EuropeBetRepository
import com.nikego.repositories.PlusMinusRepository
import com.nikego.utils.extensions.getSuccess
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class MamontScamReshaet(
    private val europeBetRepository: EuropeBetRepository,
    private val plusMinusRepository: PlusMinusRepository
) {

    fun getBetsData(betRequest: BetRequest) =
        Observable.merge(
            europeBetRepository.getBetsData(betRequest.betDisciplines).map { BetCompany.EUROPE_BET to it },
            plusMinusRepository.getBetsData(betRequest.betDisciplines).map { BetCompany.PLUS_MINUS to it }
        )
            .subscribeOn(Schedulers.io())
            .toList()
            .map { companyToUni -> companyToUni.groupBy({ it.first }, { it.second }) }
            .map { it.map { entry -> BetsData(entry.key.companyName, entry.value.getSuccess()) } }
}