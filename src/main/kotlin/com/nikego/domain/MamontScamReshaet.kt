package com.nikego.domain

import com.nikego.model.base.BetCompany
import com.nikego.model.base.uni.BetsData
import com.nikego.model.domain.BetRequest
import com.nikego.repositories.EuropeBetRepository
import com.nikego.utils.extensions.getSuccess
import javax.inject.Singleton

@Singleton
class MamontScamReshaet(private val europeBetRepository: EuropeBetRepository) {

    fun getBetsData(betRequest: BetRequest) =
        europeBetRepository.getBetsData(betRequest.betDisciplines)
            .toList()
            .map { BetsData(BetCompany.BETCITY.companyName, it.getSuccess()) }
}