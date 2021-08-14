package com.nikego.domain

import com.nikego.model.domain.BetRequest
import com.nikego.repositories.EuropeBetRepository
import javax.inject.Singleton

@Singleton
class MamontScamReshaet(private val europeBetRepository: EuropeBetRepository) {

    fun getBetsData(betRequest: BetRequest) = europeBetRepository.getBetsData(betRequest.betDisciplines)
}